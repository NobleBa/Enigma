// package com.projetjee.Enigma.service;

// import com.projetjee.Enigma.models.Pays;
// import com.projetjee.Enigma.repository.PaysDAO;
// import lombok.AllArgsConstructor;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// @AllArgsConstructor
// public class PaysServiceImpl implements PaysService{

//     private final PaysDAO paysDAO;

//     @Override
//     public Pays creer(Pays pays) {
//         return paysDAO.save(pays);
//     }

//     @Override
//     public List<Pays> lire() {
//         return paysDAO.findAll();
//     }

//     @Override
//     public Pays modifier(String Nompays, Pays pays) {
//         return paysDAO.findById(Nompays)
//                 .map(p-> {
//                     p.setQ1(p.getQ1());
//                     p.setQ2(p.getQ2());
//                     p.setQ3(p.getQ3());
//                     p.setQ4(p.getQ4());
//                     p.setQ5(p.getQ5());
//                     p.setQ6(p.getQ6());
//                     p.setNumVers(p.getNumVers());
//                     return paysDAO.save(p);
//                 }).orElseThrow(() -> new RuntimeException("Pays non trouvé"));
//     }

//     @Override
//     public String supprimer(String NomPays) {
//         paysDAO.deleteById(NomPays);
//         return "Pays supprimé";
//     }
// }
