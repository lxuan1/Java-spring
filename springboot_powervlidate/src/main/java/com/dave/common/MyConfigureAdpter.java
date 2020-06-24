package com.dave.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.Formatter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.lang.Nullable;
import org.springframework.validation.MessageCodesResolver;
import org.springframework.validation.Validator;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import java.util.List;

/**
 * @Author CRIC-ludawei
 * @Datatime 2020/6/4 12:25
 * @Version 1.0.0
 * @Description   自定义系统配置
 **/
@Configuration
public class MyConfigureAdpter implements WebMvcConfigurer {
    /**
     * Helps with configuring HandlerMappings path matching options such as trailing slash match,
     * suffix registration, path matcher and path helper.
     * Configured path matcher and path helper instances are shared for:
     * <ul>
     * <li>RequestMappings</li>
     * <li>ViewControllerMappings</li>
     * <li>ResourcesMappings</li>
     * </ul>
     * @since 4.0.3
     */
    public void configurePathMatch(PathMatchConfigurer configurer) {
        System.out.println(configurer);
    }

    /**
     * Configure content negotiation options.
     */
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    }

    /**
     * Configure asynchronous request handling options.
     */
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
    }

    /**
     * Configure a handler to delegate unhandled requests by forwarding to the
     * Servlet container's "default" servlet. A common use case for this is when
     * the {@link DispatcherServlet} is mapped to "/" thus overriding the
     * Servlet container's default handling of static resources.
     */
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    }

    /**
     * Add {@link Converter Converters} and {@link Formatter Formatters} in addition to the ones
     * registered by default.
     */
    public void addFormatters(FormatterRegistry registry) {
    }

    /**
     * Add Spring MVC lifecycle interceptors for pre- and post-processing of
     * controller method invocations and resource handler requests.
     * Interceptors can be registered to apply to all requests or be limited
     * to a subset of URL patterns.
     */
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new PowerInterptor());
    }

    /**
     * Add handlers to serve static resources such as images, js, and, css
     * files from specific locations under web application root, the classpath,
     * and others.
     */
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("classpath:/public/*","classpath:/upload/");
    }

    /**
     * Configure cross origin requests processing.
     * @since 4.2
     */
    public void addCorsMappings(CorsRegistry registry) {
    }

    /**
     * Configure simple automated controllers pre-configured with the response
     * status code and/or a view to render the response body. This is useful in
     * cases where there is no need for custom controller logic -- e.g. render a
     * home page, perform simple site URL redirects, return a 404 status with
     * HTML content, a 204 with no content, and more.
     */
    public void addViewControllers(ViewControllerRegistry registry) {

    }

    /**
     * Configure view resolvers to translate String-based view names returned from
     * controllers into concrete {@link org.springframework.web.servlet.View}
     * implementations to perform rendering with.
     * @since 4.1
     */
    public void configureViewResolvers(ViewResolverRegistry registry) {

    }

    /**
     * Add resolvers to support custom controller method argument types.
     * <p>This does not override the built-in support for resolving handler
     * method arguments. To customize the built-in support for argument
     * resolution, configure {@link RequestMappingHandlerAdapter} directly.
     * @param resolvers initially an empty list
     */
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {
    }

    /**
     * Add handlers to support custom controller method return value types.
     * <p>Using this option does not override the built-in support for handling
     * return values. To customize the built-in support for handling return
     * values, configure RequestMappingHandlerAdapter directly.
     * @param handlers initially an empty list
     */
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> handlers) {
    }

    /**
     * Configure the {@link HttpMessageConverter HttpMessageConverters} to use for reading or writing
     * to the body of the request or response. If no converters are added, a
     * default list of converters is registered.
     * <p><strong>Note</strong> that adding converters to the list, turns off
     * default converter registration. To simply add a converter without impacting
     * default registration, consider using the method
     * {@link #extendMessageConverters(java.util.List)} instead.
     * @param converters initially an empty list of converters
     */
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
    }

    /**
     * A hook for extending or modifying the list of converters after it has been
     * configured. This may be useful for example to allow default converters to
     * be registered and then insert a custom converter through this method.
     * @param converters the list of configured converters to extend.
     * @since 4.1.3
     */
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
    }

    /**
     * Configure exception resolvers.
     * <p>The given list starts out empty. If it is left empty, the framework
     * configures a default set of resolvers, see
     * {@link WebMvcConfigurationSupport#addDefaultHandlerExceptionResolvers(List, org.springframework.web.accept.ContentNegotiationManager)}.
     * Or if any exception resolvers are added to the list, then the application
     * effectively takes over and must provide, fully initialized, exception
     * resolvers.
     * <p>Alternatively you can use
     * {@link #extendHandlerExceptionResolvers(List)} which allows you to extend
     * or modify the list of exception resolvers configured by default.
     * @param resolvers initially an empty list
     * @see #extendHandlerExceptionResolvers(List)
     * @see WebMvcConfigurationSupport#addDefaultHandlerExceptionResolvers(List, org.springframework.web.accept.ContentNegotiationManager)
     */
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
    }

    /**
     * Extending or modify the list of exception resolvers configured by default.
     * This can be useful for inserting a custom exception resolver without
     * interfering with default ones.
     * @param resolvers the list of configured resolvers to extend
     * @since 4.3
     * @see WebMvcConfigurationSupport#addDefaultHandlerExceptionResolvers(List, org.springframework.web.accept.ContentNegotiationManager)
     */
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
    }

    /**
     * Provide a custom {@link Validator} instead of the one created by default.
     * The default implementation, assuming JSR-303 is on the classpath, is:
     * {@link org.springframework.validation.beanvalidation.OptionalValidatorFactoryBean}.
     * Leave the return value as {@code null} to keep the default.
     */
    @Nullable
    public Validator getValidator() {
        return null;
    }

    /**
     * Provide a custom {@link MessageCodesResolver} for building message codes
     * from data binding and validation error codes. Leave the return value as
     * {@code null} to keep the default.
     */
    @Nullable
    public MessageCodesResolver getMessageCodesResolver() {
        return null;
    }
}
