package test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

public class TestClasspathPrefiex {

    @Test
    public void testClasspathPrefix() throws Exception {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        Resource[] resources = resolver.getResources("classpath:META-INF/INDEX.LIST");

        Assert.assertEquals(1, resources.length);

        resources = resolver.getResources("classpath:META-INF/*.LIST");

        Assert.assertTrue(resources.length == 1);
    }
}
