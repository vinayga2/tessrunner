package dynamic.groovy

import com.optum.tessrunner.config.config.InitializerConfig
import com.optum.tessrunner.service.TessService
import com.optum.tessrunner.util.Benchmark
import net.sourceforge.tess4j.Tesseract1
import org.springframework.web.multipart.MultipartFile

import javax.imageio.ImageIO
import java.awt.image.BufferedImage
import java.util.logging.Logger

class GTessRunner extends TessService {
    Logger logger = Logger.getGlobal();

    @Override
    public String runTesseract(MultipartFile file) throws Exception {
        String filename = file.getOriginalFilename();
        logger.info("Accept file ${filename}");
        Benchmark benchmark = new Benchmark(this.getClass());
        benchmark.start("Run Tesseract for ${filename}");
        byte [] data = file.getBytes();
        ByteArrayInputStream bis = new ByteArrayInputStream(data);
        BufferedImage bufferedImage = ImageIO.read(bis);

        Tesseract1 tesseract = new Tesseract1();
        tesseract.setHocr(true);
        tesseract.setDatapath(InitializerConfig.TesseractFolder);

        String hocr = tesseract.doOCR(bufferedImage);
        benchmark.log();
        return hocr;
    }
}
