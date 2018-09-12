package sopramonboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import sopramonbis.model.Utilisateur;
import sopramonboot.dao.IDAOUtilisateur;




@Service
public class AuthService implements UserDetailsService {

	@Autowired
	IDAOUtilisateur daoUtilisateur;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		return new UtilisateurPrincipal(this.daoUtilisateur.findByUsername(username));
		
		Utilisateur myUtilisateur = this.daoUtilisateur.findByUsername(username);
		UtilisateurPrincipal myPrincipal = new UtilisateurPrincipal(myUtilisateur);
		return myPrincipal;
		
	}

		
	}
