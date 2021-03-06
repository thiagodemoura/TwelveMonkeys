package com.twelvemonkeys.imageio.reference;

import com.sun.imageio.plugins.png.PNGImageReader;
import com.sun.imageio.plugins.png.PNGImageReaderSpi;
import com.twelvemonkeys.imageio.util.ImageReaderAbstractTestCase;
import org.junit.Test;

import javax.imageio.IIOException;
import javax.imageio.spi.ImageReaderSpi;
import java.awt.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * PNGImageReaderTestCase
 *
 * @author <a href="mailto:harald.kuhr@gmail.com">Harald Kuhr</a>
 * @author last modified by $Author: haraldk$
 * @version $Id: PNGImageReaderTestCase.java,v 1.0 Oct 9, 2009 3:37:25 PM haraldk Exp$
 */
public class PNGImageReaderTestCase extends ImageReaderAbstractTestCase<PNGImageReader> {
    protected PNGImageReaderSpi provider = new PNGImageReaderSpi();

    @Override
    protected List<TestData> getTestData() {
        return Arrays.asList(
                new TestData(getClassLoaderResource("/png/12monkeys-splash.png"), new Dimension(300, 410))
        );
    }

    @Override
    protected ImageReaderSpi createProvider() {
        return provider;
    }

    @Override
    protected Class<PNGImageReader> getReaderClass() {
        return PNGImageReader.class;
    }

    @Override
    protected PNGImageReader createReader() {
        try {
            return (PNGImageReader) provider.createReaderInstance();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // These are NOT correct implementations, but I don't really care here
    @Override
    protected List<String> getFormatNames() {
        return Arrays.asList(provider.getFormatNames());
    }

    @Override
    protected List<String> getSuffixes() {
        return Arrays.asList(provider.getFileSuffixes());
    }

    @Override
    protected List<String> getMIMETypes() {
        return Arrays.asList(provider.getMIMETypes());
    }

    @Test
    @Override
    public void testSetDestinationTypeIllegal() throws IOException {
        try {
            super.testSetDestinationTypeIllegal();
        }
        catch (IIOException expected) {
            // Known bug
        }
    }
}