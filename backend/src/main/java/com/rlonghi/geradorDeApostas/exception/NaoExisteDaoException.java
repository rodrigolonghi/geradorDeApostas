package com.rlonghi.geradorDeApostas.exception;

public class NaoExisteDaoException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public NaoExisteDaoException(String message) {
        super(message);
    }
}
