package com.itpro.shop.filter;

import com.alibaba.fastjson.JSONObject;
import com.itpro.shop.common.exception.CustomException;
import com.itpro.shop.common.response.ResponseState;
import com.itpro.shop.common.response.ResponseVO;
import org.springframework.boot.jackson.JsonObjectSerializer;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "ItShopSSOFiler", urlPatterns = {"/*"})
public class ItShopSSOFiler implements Filter {

    //标示符：表示当前用户未登录(可根据自己项目需要改为json样式)
    String NO_LOGIN = "您还未登录";

    //不需要登录就可以访问的路径(比如:注册登录等)
    String[] includeUrls = new String[]{"/login","register"};

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession(false);
        String uri = request.getRequestURI();

        System.out.println("filter url:"+uri);
        //是否需要过滤
        boolean needFilter = isNeedFilter(uri);


        if (!needFilter) { //不需要过滤直接传给下一个过滤器
            filterChain.doFilter(servletRequest, servletResponse);
        } else { //需要过滤器
            // session中包含user对象,则是登录状态
            if(session!=null&&session.getAttribute("user") != null){
                filterChain.doFilter(request, response);
            }else{
                //用户未登录
                this.writeResponseVO(response,ResponseState.TIMEOUT.getCode(),ResponseState.TIMEOUT.getMsg());
            }
        }
    }

    /**
     * 是否需要过滤
     * @param uri
     */
    public boolean isNeedFilter(String uri) {
        for (String includeUrl : includeUrls) {
            if(includeUrl.equals(uri)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 返回前台处理
     */
    public void writeResponseVO(ServletResponse servletResponse,String code, String msg){
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //设置字符集
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter pw = null;

        try {
            pw = response.getWriter();
            ResponseVO responseVO = new ResponseVO(code,msg);
            JSONObject json = new JSONObject(responseVO);
            pw.append(json.toString());
        } catch (IOException ex){

        } finally {
            pw.close();
        }
    }
}
