/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cz.a7b36usi.sklad.DTO;

import cz.a7b36usi.sklad.BO.DocumentType;
import java.util.Date;

/**
 *
 * @author Peter
 */
public class DocumentDTO extends AbstractDTO{
     private DocumentType documentType;

    private Long partner;
    
    private int number;

    private Date date;
  

    public DocumentDTO(Long id,DocumentType documentType, Long partner, int number, Date date) {
        this.documentType = documentType;
        this.partner = partner;
        this.number = number;
        this.date = date;
        this.id = id;
    }
    
    //********************* GETTERS AND SETTERS ********************************
    
    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public Long getPartner() {
        return partner;
    }

    public void setPartner(Long partner) {
        this.partner = partner;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}