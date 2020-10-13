package com.gestion.gestionecole;

import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.gestion.gestionecole.models.AnneeClasse;
import com.gestion.gestionecole.models.AnneeScolaire;
import com.gestion.gestionecole.models.Annexe;
import com.gestion.gestionecole.models.Classe;
import com.gestion.gestionecole.models.Dossier;
import com.gestion.gestionecole.models.Eleve;
import com.gestion.gestionecole.models.Inscription;
import com.gestion.gestionecole.models.TypeAnnexe;
import com.gestion.gestionecole.models.TypeDossier;
import com.gestion.gestionecole.models.TypeVersement;
import com.gestion.gestionecole.models.Versement;
import com.gestion.gestionecole.service.implement.AnneeClasseService;
import com.gestion.gestionecole.service.implement.AnneeScolaireService;
import com.gestion.gestionecole.service.implement.AnnexeService;
import com.gestion.gestionecole.service.implement.ClasseService;
import com.gestion.gestionecole.service.implement.DossierService;
import com.gestion.gestionecole.service.implement.EleveService;
import com.gestion.gestionecole.service.implement.InscriptionService;
import com.gestion.gestionecole.service.implement.TypeAnnexeService;
import com.gestion.gestionecole.service.implement.TypeDossierService;
import com.gestion.gestionecole.service.implement.TypeVersementService;
import com.gestion.gestionecole.service.implement.VersementService;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import net.bytebuddy.utility.RandomString;

@SpringBootApplication
public class GestionEcoleApplication implements CommandLineRunner{
	
	@Autowired ClasseService classeService;
	@Autowired AnneeScolaireService anneeScolaireService;
	@Autowired AnneeClasseService anneeClasseService;
	@Autowired TypeDossierService typeDossierService;
	@Autowired DossierService dossierService;
	@Autowired TypeAnnexeService typeAnnexeService;
	@Autowired AnnexeService annexeService;
	@Autowired TypeVersementService typeVersementService;
	@Autowired VersementService versementService;
	@Autowired EleveService eleveService;
	@Autowired InscriptionService inscriptionService;
		

	public static void main(String[] args) {
		SpringApplication.run(GestionEcoleApplication.class, args);
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
	return new BCryptPasswordEncoder();
	}
	

	@Override
	public void run(String... args) throws Exception {
		
		
		/*
		 * Random rdm = new Random();
		 * 
		 * Classe cp1 = classeService.save(new Classe(null, "cp1", null)); Classe cp2 =
		 * classeService.save(new Classe(null, "cp2", null)); Classe ce1 =
		 * classeService.save(new Classe(null, "ce1", null)); Classe ce2 =
		 * classeService.save(new Classe(null, "ce2", null)); Classe cm1 =
		 * classeService.save(new Classe(null, "cm1", null)); Classe cm2 =
		 * classeService.save(new Classe(null, "cm2", null)); Classe sixeme =
		 * classeService.save(new Classe(null, "6ieme", null)); Classe cinquieme =
		 * classeService.save(new Classe(null, "5ieme", null)); Classe quatrieme =
		 * classeService.save(new Classe(null, "4ieme", null)); Classe troisieme =
		 * classeService.save(new Classe(null, "3ieme", null)); Classe secondA =
		 * classeService.save(new Classe(null, "2ndA", null)); Classe secondC =
		 * classeService.save(new Classe(null, "2ndc", null)); Classe secondB =
		 * classeService.save(new Classe(null, "2ndB", null)); Classe secondG1 =
		 * classeService.save(new Classe(null, "2ndG1", null)); Classe secondG2 =
		 * classeService.save(new Classe(null, "2ndG1", null)); Classe premiereA1 =
		 * classeService.save(new Classe(null, "1erA1", null)); Classe premiereA2 =
		 * classeService.save(new Classe(null, "1erA2", null)); Classe premiereB =
		 * classeService.save(new Classe(null, "1erB", null)); Classe premiereD =
		 * classeService.save(new Classe(null, "1erD", null)); Classe premiereC =
		 * classeService.save(new Classe(null, "1erC", null)); Classe premiereG1 =
		 * classeService.save(new Classe(null, "1erG1", null)); Classe premiereG2 =
		 * classeService.save(new Classe(null, "1erG2", null)); Classe terminaleA1 =
		 * classeService.save(new Classe(null, "TleA1", null)); Classe terminaleA2 =
		 * classeService.save(new Classe(null, "TleA2", null)); Classe terminaleB =
		 * classeService.save(new Classe(null, "TleB", null)); Classe terminaleC =
		 * classeService.save(new Classe(null, "TleC", null)); Classe terminaleD =
		 * classeService.save(new Classe(null, "TleD", null)); Classe terminaleG1 =
		 * classeService.save(new Classe(null, "TleG1", null)); Classe terminaleG2=
		 * classeService.save(new Classe(null, "TleG2", null));
		 * 
		 * AnneeScolaire a1 = anneeScolaireService.save(new AnneeScolaire( new Date(),
		 * new Date(), RandomString.make(10), null));
		 * 
		 * AnneeClasse anneeClasse = anneeClasseService.save( new
		 * AnneeClasse(100+rdm.nextInt(10000), sixeme, a1));
		 * 
		 * TypeDossier td1 = typeDossierService.save( new TypeDossier(null,
		 * "fiche inscription en ligne", null)); TypeDossier td2 =
		 * typeDossierService.save( new TypeDossier(null, "fiche inscription", null));
		 * TypeDossier td3 = typeDossierService.save( new TypeDossier(null,
		 * "attestation du BEPC", null)); TypeDossier td4 = typeDossierService.save( new
		 * TypeDossier(null, "attestation du BEPC", null)); TypeDossier td5 =
		 * typeDossierService.save( new TypeDossier(null, "attestation du CAP", null));
		 * TypeDossier td6 = typeDossierService.save( new TypeDossier(null,
		 * "attestation du BT", null)); TypeDossier td7 = typeDossierService.save( new
		 * TypeDossier(null, "bulletin", null));
		 * 
		 * TypeAnnexe ta1 = typeAnnexeService.save( new TypeAnnexe(null, "Photos",
		 * null)); TypeAnnexe ta2 = typeAnnexeService.save( new TypeAnnexe(null, "Ram",
		 * null)); TypeAnnexe ta3 = typeAnnexeService.save( new TypeAnnexe(null,
		 * "Blouse", null));
		 * 
		 * TypeVersement tv1 = typeVersementService.save( new TypeVersement(null,
		 * "premier versement", null)); TypeVersement tv2 = typeVersementService.save(
		 * new TypeVersement(null, "deuxieme versement", null)); TypeVersement tv3 =
		 * typeVersementService.save( new TypeVersement(null, "troisieme versement",
		 * null));
		 * 
		 * 
		 * Inscription ins1 =inscriptionService.save( new Inscription(null,
		 * RandomString.make(10), 1+rdm.nextLong(), 0, 1, 1, 0, 0, 1, anneeClasse, null,
		 * null, null, null) );
		 * 
		 * Inscription ins2 =inscriptionService.save( new Inscription(null,
		 * RandomString.make(10), 1+rdm.nextLong(), 1, 1, 1,1, 1, 1, anneeClasse, null,
		 * null, null, null) );
		 * 
		 * Inscription ins3 =inscriptionService.save( new Inscription(null,
		 * RandomString.make(10), 1+rdm.nextLong(), 0, 1, 0, 1, 0, 1, anneeClasse, null,
		 * null, null, null) );
		 * 
		 * Inscription ins4 =inscriptionService.save( new Inscription(null,
		 * RandomString.make(10), 1+rdm.nextLong(), 0, 0, 0, 1, 1, 1, anneeClasse, null,
		 * null, null, null) );
		 * 
		 * Inscription ins5 =inscriptionService.save( new Inscription(null,
		 * RandomString.make(10), 1+rdm.nextLong(), 1, 1, 1, 0, 0, 0, anneeClasse, null,
		 * null, null, null) );
		 * 
		 * Inscription ins6 =inscriptionService.save( new Inscription(null,
		 * RandomString.make(10), 1+rdm.nextLong(), 0, 0, 0, 0, 0, 0, anneeClasse, null,
		 * null, null, null) );
		 * 
		 * Eleve elv1 = eleveService.save( new Eleve(null, RandomString.make(10),
		 * RandomString.make(10), RandomString.make(10), "Homme", new Date(),
		 * RandomString.make(10), ins1)); Eleve elv2 = eleveService.save( new
		 * Eleve(null, RandomString.make(10), RandomString.make(10),
		 * RandomString.make(10), "Homme", new Date(), RandomString.make(10), ins2));
		 * 
		 * Eleve elv3 = eleveService.save( new Eleve(null, RandomString.make(10),
		 * RandomString.make(10), RandomString.make(10), "Femme", new Date(),
		 * RandomString.make(10), ins3));
		 * 
		 * Eleve elv4 = eleveService.save( new Eleve(null, RandomString.make(10),
		 * RandomString.make(10), RandomString.make(10), "Homme", new Date(),
		 * RandomString.make(10), ins4));
		 * 
		 * Eleve elv5 = eleveService.save( new Eleve(null, RandomString.make(10),
		 * RandomString.make(10), RandomString.make(10), "Homme", new Date(),
		 * RandomString.make(10), ins5));
		 * 
		 * Eleve elv6 = eleveService.save( new Eleve(null, RandomString.make(10),
		 * RandomString.make(10), RandomString.make(10), "Femme", new Date(),
		 * RandomString.make(10), ins1));
		 * 
		 * Eleve elv7 = eleveService.save( new Eleve(null, RandomString.make(10),
		 * RandomString.make(10), RandomString.make(10), "Homme", new Date(),
		 * RandomString.make(10), ins2));
		 * 
		 * Eleve elv8 = eleveService.save( new Eleve(null, RandomString.make(10),
		 * RandomString.make(10), RandomString.make(10), "Femme", new Date(),
		 * RandomString.make(10), ins3));
		 * 
		 * Eleve elv9 = eleveService.save( new Eleve(null, RandomString.make(10),
		 * RandomString.make(10), RandomString.make(10), "Homme", new Date(),
		 * RandomString.make(10), ins4));
		 * 
		 * Eleve elv10 = eleveService.save( new Eleve(null, RandomString.make(10),
		 * RandomString.make(10), RandomString.make(10), "Femme", new Date(),
		 * RandomString.make(10), ins5));
		 * 
		 * Eleve elv11 = eleveService.save( new Eleve(null, RandomString.make(10),
		 * RandomString.make(10), RandomString.make(10), "Homme", new Date(),
		 * RandomString.make(10), ins6));
		 * 
		 * Dossier dos1 = dossierService.save( new Dossier(null, 0, td1, ins1)); Dossier
		 * dos2 = dossierService.save( new Dossier(null, 0, td2, ins2)); Dossier dos3 =
		 * dossierService.save( new Dossier(null, 0, td3, ins3)); Dossier dos4 =
		 * dossierService.save( new Dossier(null, 0, td4, ins4)); Dossier dos5 =
		 * dossierService.save( new Dossier(null, 0, td5, ins5)); Dossier dos6 =
		 * dossierService.save( new Dossier(null, 0, td6, ins6));
		 * 
		 * Annexe anx1 = annexeService.save(new Annexe(null, 1, ta1, ins1)); Annexe anx2
		 * = annexeService.save(new Annexe(null, 0, ta2, ins3)); Annexe anx3 =
		 * annexeService.save(new Annexe(null, 1, ta3, ins2)); Annexe anx4 =
		 * annexeService.save(new Annexe(null, 0, ta1, ins4)); Annexe anx5 =
		 * annexeService.save(new Annexe(null, 1, ta3, ins5));
		 * 
		 * Versement vers1 = versementService.save( new Versement(null,
		 * 100+rdm.nextInt(10000), new Date(), new Date(), "Janvier", tv1, ins1));
		 * 
		 * Versement vers2 = versementService.save( new Versement(null,
		 * 100+rdm.nextInt(10000), new Date(), new Date(), "Fevrier", tv2, ins2));
		 * 
		 * Versement vers3 = versementService.save( new Versement(null,
		 * 100+rdm.nextInt(10000), new Date(), new Date(), "Mars", tv3, ins3));
		 */
	}

}
