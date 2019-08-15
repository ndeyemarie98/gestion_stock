package sn.kubejara.gestion_stock.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Entity
@Data
public class Stock {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idStock;
	private int nbprod;
	@Temporal(TemporalType.DATE)
	private Date date_per;
	@ManyToOne
	private Produit produit;
}
