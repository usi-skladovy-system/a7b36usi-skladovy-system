/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.a7b36usi.sklad.Service;

import cz.a7b36usi.sklad.BO.DocumentBO;
import cz.a7b36usi.sklad.BO.MovementBO;
import cz.a7b36usi.sklad.BO.PartnerBO;
import cz.a7b36usi.sklad.BO.ProductBO;
import cz.a7b36usi.sklad.BO.ProductVersionBO;
import cz.a7b36usi.sklad.BO.WrappingTypeBO;
import cz.a7b36usi.sklad.DTO.DocumentDTO;
import cz.a7b36usi.sklad.DTO.MovementDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Peter
 */
public class DocumentService extends AbstractService implements IDocumentService {

    public Long saveDocument(DocumentDTO document) {
        DocumentBO bo = new DocumentBO();
        bo.setDate(document.getDate());
        bo.setDocumentType(document.getDocumentType());
        bo.setId(document.getId());
        bo.setNumber(document.getNumber());
        bo.setPartner(genericDAO.loadById(document.getPartner(), PartnerBO.class));
        return genericDAO.saveOrUpdate(bo).getId();
    }

    public Long saveMovement(MovementDTO movement) {
        MovementBO bo = new MovementBO();
        bo.setId(movement.getId());
        bo.setPrice(movement.getPrice());
        bo.setDocument(genericDAO.loadById(movement.getDocument(), DocumentBO.class));
        bo.setProdukt(genericDAO.loadById(movement.getProdukt(), ProductBO.class));
        bo.setVersion(genericDAO.loadById(movement.getVersion(), ProductVersionBO.class));
        bo.setWrapping(genericDAO.loadById(movement.getWrapping(), WrappingTypeBO.class));
        return genericDAO.saveOrUpdate(bo).getId();
    }

    public void removeDocument(Long documentId) {
        genericDAO.removeById(documentId, DocumentBO.class);
    }

    public void removeMovement(Long movementId) {
        genericDAO.removeById(movementId, MovementBO.class);
    }

    public List<DocumentDTO> getAllDocuments() {
        List<DocumentDTO> dtos = new ArrayList<DocumentDTO>();
        List<DocumentBO> bos = genericDAO.getAll(DocumentBO.class);
        for (DocumentBO documentBO : bos) {
            DocumentDTO dto = new DocumentDTO(
                    documentBO.getId(),
                    documentBO.getDocumentType(),
                    documentBO.getPartner().getId(),
                    documentBO.getNumber(),
                    documentBO.getDate());
            dtos.add(dto);
        }
        return dtos;
    }

    public List<MovementDTO> getAllMovements() {
        List<MovementDTO> dtos = new ArrayList<MovementDTO>();
        List<MovementBO> bos = genericDAO.getAll(MovementBO.class);
        for (MovementBO movementBO : bos) {
            MovementDTO dto = new MovementDTO(
                    movementBO.getId(),
                    movementBO.getPrice(),
                    movementBO.getWrapping().getId(),
                    movementBO.getVersion().getId(),
                    movementBO.getProdukt().getId(),
                    movementBO.getDocument().getId());
            dtos.add(dto);
        }
        return dtos;
    }

    public List<MovementDTO> getAllDocumentsMovements(Long documentId) {
        List<MovementDTO> dtos = new ArrayList<MovementDTO>();
        List<MovementBO> bos = genericDAO.getByProperty("document", genericDAO.loadById(documentId, DocumentBO.class), MovementBO.class);
        for (MovementBO movementBO : bos) {
            MovementDTO dto = new MovementDTO(
                    movementBO.getId(),
                    movementBO.getPrice(),
                    movementBO.getWrapping().getId(),
                    movementBO.getVersion().getId(),
                    movementBO.getProdukt().getId(),
                    movementBO.getDocument().getId());
            dtos.add(dto);
        }
        return dtos;
    }

    public List<DocumentDTO> getAllPartnersDocuments(Long partnerId) {
                List<DocumentDTO> dtos = new ArrayList<DocumentDTO>();
        List<DocumentBO> bos = genericDAO.getByProperty("partner", genericDAO.loadById(partnerId, PartnerBO.class), DocumentBO.class);
        for (DocumentBO documentBO : bos) {
            DocumentDTO dto = new DocumentDTO(
                    documentBO.getId(),
                    documentBO.getDocumentType(),
                    documentBO.getPartner().getId(),
                    documentBO.getNumber(),
                    documentBO.getDate());
            dtos.add(dto);
        }
        return dtos;
    }

    public List<MovementDTO> getAllProductsMovements(Long productId) {
        List<MovementDTO> dtos = new ArrayList<MovementDTO>();
        List<MovementBO> bos = genericDAO.getByProperty("product", genericDAO.loadById(productId, ProductBO.class), MovementBO.class);
        for (MovementBO movementBO : bos) {
            MovementDTO dto = new MovementDTO(
                    movementBO.getId(),
                    movementBO.getPrice(),
                    movementBO.getWrapping().getId(),
                    movementBO.getVersion().getId(),
                    movementBO.getProdukt().getId(),
                    movementBO.getDocument().getId());
            dtos.add(dto);
        }
        return dtos;
    }

}
