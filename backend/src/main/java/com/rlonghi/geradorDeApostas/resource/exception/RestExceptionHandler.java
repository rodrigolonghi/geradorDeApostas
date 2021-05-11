package com.rlonghi.geradorDeApostas.resource.exception;

import org.hibernate.JDBCException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.rlonghi.geradorDeApostas.domain.DetalheErro;
import com.rlonghi.geradorDeApostas.exception.ApostadorRepeditoException;
import com.rlonghi.geradorDeApostas.exception.NaoExisteDaoException;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({JDBCException.class})
    public ResponseEntity<Object> apostadorComApostas(ConstraintViolationException ex, WebRequest request) {
        return handleExceptionInternal(
                ex, DetalheErro.builder()
                        .addDetalhe("Este apostador possui apostas cadastradas. Logo, não pode ser excluido.")
                        .addErro(ex.getMessage())
                        .addStatus(HttpStatus.BAD_REQUEST)
                        .addHttpMethod(getHttpMethod(request))
                        .addPath(getPath(request))
                        .build(),
                new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({ApostadorRepeditoException.class})
    public ResponseEntity<Object> emailRepetido(ApostadorRepeditoException ex, WebRequest request) {
        return handleExceptionInternal(
                ex, DetalheErro.builder()
                        .addDetalhe("Este e-mail já está associado a outro apostador.")
                        .addErro(ex.getMessage())
                        .addStatus(HttpStatus.CONFLICT)
                        .addHttpMethod(getHttpMethod(request))
                        .addPath(getPath(request))
                        .build(),
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

    @ExceptionHandler({NaoExisteDaoException.class})
    public ResponseEntity<Object> entidadeNaoEncontrada(NaoExisteDaoException ex, WebRequest request) {

        return handleExceptionInternal(
                ex, DetalheErro.builder()
                        .addDetalhe("Recurso não encontrado na base de dados.")
                        .addErro(ex.getMessage())
                        .addStatus(HttpStatus.NOT_FOUND)
                        .addHttpMethod(getHttpMethod(request))
                        .addPath(getPath(request))
                        .build(),
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }

    @ExceptionHandler({NullPointerException.class, IllegalArgumentException.class})
    public ResponseEntity<Object> serverException(RuntimeException ex, WebRequest request) {

        return handleExceptionInternal(
                ex, DetalheErro.builder()
                        .addDetalhe("O recurso que você tentou acessar não existe.")
                        .addErro(ex.getMessage())
                        .addStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                        .addHttpMethod(getHttpMethod(request))
                        .addPath(getPath(request))
                        .build(),
                new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    private String getPath(WebRequest request) {
        return ((ServletWebRequest) request).getRequest().getRequestURI();
    }

    private String getHttpMethod(WebRequest request) {
        return ((ServletWebRequest) request).getRequest().getMethod();
    }
}
