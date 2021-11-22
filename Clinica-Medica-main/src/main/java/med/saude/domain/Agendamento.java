package med.saude.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@SuppressWarnings("serial")
@Entity
@Table(name = "AGENDAMENTO")
public class Agendamento extends AbstractEntity<Long> {

	@Column
	private String descricao;
	
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_consulta", nullable = false, columnDefinition = "DATE")
	private LocalDate dataConsulta;
	
	@ManyToOne
	@JoinColumn(name = "paciente_id")
	private Paciente paciente;
	
	@ManyToOne
	@JoinColumn(name = "especialidade_id")
	private Especialidade especialidade;
			
	@ManyToOne
	@JoinColumn(name = "medico_id")
	private Medico medico;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(LocalDate dataConsulta) {
		this.dataConsulta = dataConsulta;
	}

	public Especialidade getEspecialidades() {
		return especialidade;
	}

	public void setEspecialidades(Especialidade especialidades) {
		this.especialidade = especialidades;
	}

	public Medico getMedicos() {
		return medico;
	}

	public void setMedicos(Medico medicos) {
		this.medico = medicos;
	}
	public Paciente getPacientes() {
		return paciente;
	}

	public void setPacientes(Paciente pacientes) {
		this.paciente = pacientes;
	}


}
