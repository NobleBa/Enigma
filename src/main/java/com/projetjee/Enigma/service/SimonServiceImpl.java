// package com.projetjee.Enigma.service;

// import com.projetjee.Enigma.models.Simon;
// import com.projetjee.Enigma.repository.SimonDAO;
// import lombok.AllArgsConstructor;
// import org.springframework.stereotype.Service;

// import java.util.List;

// @Service
// @AllArgsConstructor
// public class SimonServiceImpl implements SimonService{

//     private final SimonDAO simonDAO;

//     @Override
//     public Simon creer(Simon simon) {
//         return simonDAO.save(simon);
//     }

//     @Override
//     public List<Simon> lire() {
//         return simonDAO.findAll();
//     }

//     @Override
//     public Simon modifier(String IdCase, Simon simon) {
//         return simonDAO.findById(IdCase)
//                 .map(p-> {
//                     p.setActive(p.getActive());
//                     return simonDAO.save(p);
//                 }).orElseThrow(() -> new RuntimeException("Simon non trouvé"));
//     }

//     @Override
//     public String supprimer(String IdCase) {
//         simonDAO.deleteById(IdCase);
//         return "Simon supprimé";
//     }
// }
