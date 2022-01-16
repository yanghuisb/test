package com.hui.ad.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

@Slf4j
@Component
/**
 * 通过实现ZuulFilter实现
 */
public class PreRequestFilter extends ZuulFilter {
    /**
     *
     * @return 返回过滤器的类型   pre、post、error、route
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     *  定义同一类型过滤器的执行顺序，值越小则优先级越高
     * @return 返回过滤器的优先级
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 可以通过逻辑条件判断，选择过滤器是否执行
     * @return 返回过滤器是否需要执行
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 定义过滤器具体执行的操作
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {

        RequestContext ctx=RequestContext.getCurrentContext();
        ctx.set("startTime",System.currentTimeMillis());

        return null;
    }
}
