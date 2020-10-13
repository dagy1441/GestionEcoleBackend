package com.gestion.gestionecole.security;

public class SecurityConstParams {
	
	public static final String JWT_SECRET = "gestion@ecole.ci";
	public static final long   JWT_EXPIRATION_DAYS = 864_000_000; // 10 days
//	public static final long   JWT_EXPIRATION_DAYS = 10*24*3600*1000; // 10 days
	public static final String JWT_TOKEN_PREFIX = "Bearer ";
	public static final String JWT_HEADER_NAME = "Authorization";

}
