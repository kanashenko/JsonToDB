package com.example.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Data")
public class Data {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ORDINAL", nullable=false, unique=true, length=11)
	private int ordinal;
	
	@Column(name="ID")
	private String id;	
	
	@Column(name="HASH")
	private String hash;
	
	@Column(name="FORMAT")
	private String format;	
	
	@Column(name="URL")
	private String url;
	
	@Column(name="TITLE")
	private String title;
	
	@Column(name="DOCUMENTOF")
	private String documentOf;
	
	@Column(name="DATE_PUBLISHED")
	private Date datePublished;
	
	@Column(name="DATE_MODIFIED")
	private Date dateModified;
	
	@Column(name="DOCUMENT_TYPE")
	private String documentType;
	
	@Column(name="RELATED_ITEM")
	private String relatedItem;
	
	@Column(name="DESCRIPTION")
	private String description;
	
	@Column(name="LANGUAGE")
	private String language;
	
	public int getOrdinal() {
		return ordinal;
	}
	public void setOrdinal(int ordinal) {
		this.ordinal = ordinal;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRelatedItem() {
		return relatedItem;
	}
	public void setRelatedItem(String relatedItem) {
		this.relatedItem = relatedItem;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDocumentOf() {
		return documentOf;
	}
	public void setDocumentOf(String documentOf) {
		this.documentOf = documentOf;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public Date getDatePublished() {
		return datePublished;
	}
	public void setDatePublished(Date datePublished) {
		this.datePublished = datePublished;
	}
	public Date getDateModified() {
		return dateModified;
	}
	public void setDateModified(Date dateModified) {
		this.dateModified = dateModified;
	}	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
		
	@Override
	public int hashCode() {
		int result = 31 * ((id == null) ? 0 : id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Data))
			return false;
		Data other = (Data) obj;
		return this.id == other.id;
	}
	
	@Override
	public String toString() {
		return "Data [ordinal=" + ordinal + ", id=" + id + ", hash=" + hash + ", format=" + format + ", url=" + url
				+ ", title=" + title + ", documentOf=" + documentOf + ", datePublished=" + datePublished
				+ ", dateModified=" + dateModified + ", documentType=" + documentType + ", relatedItem=" + relatedItem
				+ ", description=" + description + ", language=" + language + "]";
	}	
}
