package br.com.gs3.avaliacaotecnica.interceptor;

import br.com.gs3.avaliacaotecnica.annotation.HistoricoOperacoesRegister;
import br.com.gs3.avaliacaotecnica.enumerador.TipoOperacao;
import br.com.gs3.avaliacaotecnica.service.HistoricoOperacoesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class ClienteInterceptor extends HandlerInterceptorAdapter {


    @Autowired
    private HistoricoOperacoesService historicoOperacoesService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        HistoricoOperacoesRegister annotationHistorico = handlerMethod.getMethod().getAnnotation(HistoricoOperacoesRegister.class);
        if(null != annotationHistorico){
            Long idUsuarioLogado = Long.valueOf(request.getHeader("idUsuarioLogado"));
            historicoOperacoesService.salvar(historicoOperacoesService.criarHistorico(idUsuarioLogado, annotationHistorico.tipoOperacao()));
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {


    }
}
