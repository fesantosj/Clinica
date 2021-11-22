package med.saude.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "ESPECIALIDADE")
public class Especialidade extends AbstractEntity<Long> {
	@Column(nullable = false, unique = true)
	private String titulo;
	@Column(nullable = false, unique = true)
	private String descricao;


	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

//	public List<Medico> getMedicos() {
//		return medicos;
//	}
//
//	public void setMedicos(List<Medico> medicos) {
//		this.medicos = medicos;
//	}


}
