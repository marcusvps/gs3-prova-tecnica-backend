package br.com.gs3.avaliacaotecnica.interceptor;

import br.com.gs3.avaliacaotecnica.annotation.HistoricoOperacoesRegister;
import br.com.gs3.avaliacaotecnica.dao.entity.Usuario;
import br.com.gs3.avaliacaotecnica.enumerador.TipoOperacao;
import br.com.gs3.avaliacaotecnica.service.HistoricoOperacoesService;
import br.com.gs3.avaliacaotecnica.service.UsuarioService;
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
import java.util.Objects;
import java.util.Optional;

@Component
public class ClienteInterceptor implements HandlerInterceptor {


    @Autowired
    private HistoricoOperacoesService historicoOperacoesService;

    @Autowired
    private UsuarioService usuarioService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
            if (!(handler instanceof HandlerMethod)) {
                return false;
            }
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            HistoricoOperacoesRegister annotationHistorico = handlerMethod.getMethod().getAnnotation(HistoricoOperacoesRegister.class);
            if(null != annotationHistorico){
                Long idUsuarioLogado = Long.valueOf(Optional.ofNullable(request.getParameter("idUsuarioLogado")).orElse("0"));

                if(Objects.equals(0L, idUsuarioLogado)){
                    String login = request.getParameter("login");
                    String senha = request.getParameter("senha");
                    Usuario usuario = usuarioService.recuperarUsuarioPor(login, senha);
                    if(null != usuario){
                        idUsuarioLogado = usuario.getId();
                    }
                }
                historicoOperacoesService.salvar(historicoOperacoesService.criarHistorico(idUsuarioLogado, annotationHistorico.tipoOperacao()));

            }
        } catch (Exception e) {
            e.printStackTrace();
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
