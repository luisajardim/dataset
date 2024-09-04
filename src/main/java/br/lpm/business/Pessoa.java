package br.lpm.business;

import java.time.LocalDate;

public class Pessoa {
  private String nome;
  private LocalDate dataNascimento; 
  private Genero genero; 
  private float altura;
  private int peso; 
  private float renda;
  private String naturalidade; 
  private Hobby hobby; 
  private EstadoCivil estadoCivil;
  private Escolaridade escolaridade;
  private boolean feliz; 
  private Moradia moradia;

  public Pessoa (){

  }

  public Pessoa(String nome, LocalDate dataNascimento, Genero genero, float altura, int peso, float renda,
      String naturalidade, Hobby hobby, EstadoCivil estadoCivil, Escolaridade escolaridade, boolean feliz,
      Moradia moradia) {
    this.nome = nome;
    this.dataNascimento = dataNascimento;
    this.genero = genero;
    this.altura = altura;
    this.peso = peso;
    this.renda = renda;
    this.naturalidade = naturalidade;
    this.hobby = hobby;
    this.estadoCivil = estadoCivil;
    this.escolaridade = escolaridade;
    this.feliz = feliz;
    this.moradia = moradia;
  }


  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    if (nome != null) {
      boolean isValid = true;
      for (int i = 0; i < nome.length(); i++) {
        char c = nome.charAt(i);
        if (!Character.isLetter(c) && c != ' ') {
          isValid = false;
          break;
        }
      }
      if (isValid) {
        this.nome = nome;
      }
    }
  }

  public LocalDate getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(LocalDate dataNascimento) {
    if (dataNascimento != null) {
      LocalDate hoje = LocalDate.now();
      if (dataNascimento.isBefore(hoje)) {
        this.dataNascimento = dataNascimento;
      } else {
        System.out.println("A data de nascimento é inválida.");
      }
    }
  }

  public int getAge() {
    if (dataNascimento != null) {
      LocalDate hoje = LocalDate.now();
      int anos = hoje.getYear() - dataNascimento.getYear();
      if (hoje.getMonthValue() < dataNascimento.getMonthValue()
          || hoje.getMonthValue() == dataNascimento.getMonthValue()
              && hoje.getDayOfMonth() < dataNascimento.getDayOfMonth()) {

        anos--;
      }
      return anos;
    } else {
      return 0;
    }
  }

  public Genero getGenero() {
    return genero;
  }
  public void setGenero(Genero genero) {
    this.genero = genero;
  }
  public float getAltura() {
    return altura;
  }
  public void setAltura(float altura) {
    if (altura >0 && altura < 2.6f){
      this.altura = altura;
    }
    
  }
  public int getPeso() {
    return peso;
  }
  public void setPeso(int peso) {
    if (peso > 0 && peso < 600f) {
      this.peso = peso;
    }
    
  }
  public float getRenda() {
    return renda;
  }
  public void setRenda(float renda) {
    if (renda >= 0){
      this.renda = renda;
    }
  }
  public String getNaturalidade() {
    return naturalidade;
  }
  public void setNaturalidade(String naturalidade) {
    this.naturalidade = naturalidade;
  }
  public Hobby getHobby() {
    return hobby;
  }
  public void setHobby(Hobby hobby) {
    this.hobby = hobby;
  }
  public EstadoCivil getEstadoCivil() {
    return estadoCivil;
  }
  public void setEstadoCivil(EstadoCivil estadoCivil) {
    this.estadoCivil = estadoCivil;
  }
  public Escolaridade getEscolaridade() {
    return escolaridade;
  }
  public void setEscolaridade(Escolaridade escolaridade) {
    this.escolaridade = escolaridade;
  }
  public boolean isFeliz() {
    return feliz;
  }
  public void setFeliz(boolean feliz) {
    this.feliz = feliz;
  }
  public Moradia getMoradia() {
    return moradia;
  }
  public void setMoradia(Moradia moradia) {
    this.moradia = moradia;
  } 
  



}
