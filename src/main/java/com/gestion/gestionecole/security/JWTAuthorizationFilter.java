package com.gestion.gestionecole.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

public class JWTAuthorizationFilter extends OncePerRequestFilter{
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// pour chaque requette venant d'un autre domaine authorise les requettes et
		// envoyer les reponses
		response.addHeader("Access-Control-Allow-Origin", "*");

		// les entetes a authoriser
		response.addHeader("Access-Control-Allow-Headers",
				"Origin, Accept, X-Requested-With,Content-Type, "
				+ "Access-Control-Request-Method,"
				+ " Access-Control-Request-Headers,authorization");
		
		// exposer les reponses au client http
		response.addHeader("Access-Control-Expose-Headers",
							"Access-Control-Allow-Origin, "
							+ "Access-Control-Allow-Credentials, authorization");
		
		// authoriser toutes les methodes http
		response.addHeader("Access-Control-Allows-Methods", "GET,POST,PUT,DELETE,PATCH");

		// si une requette est envoye avec la methode option on repond ok
		if (request.getMethod().equals("OPTIONS")) {
			response.setStatus(HttpServletResponse.SC_OK);
		}
		else if (request.getRequestURI().equals("/login")) {
			filterChain.doFilter(request, response);
			return;
		}
		else {
			String jwtToken = request.getHeader(SecurityConstParams.JWT_HEADER_NAME);
			System.out.println("Token " + jwtToken);

			if (jwtToken == null || !jwtToken.startsWith(SecurityConstParams.JWT_TOKEN_PREFIX)) {
				filterChain.doFilter(request, response);
				return;
			}

			// verifier le token
			JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SecurityConstParams.JWT_SECRET)).build();

			// decoder le token apres verification
			String jwt = jwtToken.substring(SecurityConstParams.JWT_TOKEN_PREFIX.length());
			DecodedJWT decodedJWT = verifier.verify(jwt);
			System.out.println("jwt " + jwt);

			// recuperation des infos decoder du user
			String username = decodedJWT.getSubject();
			List<String> roles = decodedJWT.getClaims().get("roles").asList(String.class);
			System.out.println("username " + username);
			System.out.println("roles " + roles);

			// transformer les roles en granted
			Collection<GrantedAuthority> authorities = new ArrayList<>();
			roles.forEach(rn -> {
				authorities.add(new SimpleGrantedAuthority(rn));
			});

			// demander a spring d'authentifier les utilisateurs
			UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(username, null,
					authorities);
			SecurityContextHolder.getContext().setAuthentication(user);

			// passer au flitre suivant apres authentifiarion
			filterChain.doFilter(request, response);
		}

	}


}
