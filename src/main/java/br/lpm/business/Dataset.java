package br.lpm.business;

public class Dataset {

  private static final int MAX_PESSOAS = 150;
  private Pessoa pessoas[] = new Pessoa[MAX_PESSOAS];
  private int quantidadePessoasCadastradas = 0;

  // PERGUNTAR PROS AMIGOS QUAL TAMANHO ELES INICIALIZARAM OS DELES!!!!!!

  // MÉTODOS DE ACESSO:
  // addPessoa(Pessoa): adiciona uma pessoa na coleção.

  public void addPessoa(Pessoa pessoa) {
    if (pessoa == null || quantidadePessoasCadastradas >= MAX_PESSOAS) {
      return;
    }
    for (int i = 0; i < quantidadePessoasCadastradas; i++) {
      if (pessoas[i].equals(pessoa)) {
        return;
      }
    }
    pessoas[quantidadePessoasCadastradas] = pessoa;
    quantidadePessoasCadastradas++;
  }

  // removePessoa(Pessoa): remove uma pessoa da coleção.
  public void removePessoa(Pessoa pessoa) {
    for (int i = 0; i < quantidadePessoasCadastradas; i++) {
      if (pessoas[i] != null && pessoas[i].equals(pessoa)) {
        pessoas[i] = pessoas[quantidadePessoasCadastradas - 1];
        pessoas[quantidadePessoasCadastradas - 1] = null;
        quantidadePessoasCadastradas--;
      }
    }
  }

  // removePessoaByName(String): remove uma pessoa da coleção baseada em seu nome.
  public void removePessoaByName(String nome) {
    for (int i = 0; i < quantidadePessoasCadastradas; i++) {
      if (pessoas[i] != null && pessoas[i].getNome().equalsIgnoreCase(nome)) {
        pessoas[i] = pessoas[quantidadePessoasCadastradas - 1];
        pessoas[quantidadePessoasCadastradas - 1] = null;
        quantidadePessoasCadastradas--;
        return;
      }
    }
  }

  // replacePessoa(old: Pessoa, new: Pessoa): substitui uma pessoa por outra.
  public void replacePessoa(Pessoa pessoaAntiga, Pessoa novaPessoa) {
    if (pessoaAntiga == null || novaPessoa == null) {}
    for (int i = 0; i < quantidadePessoasCadastradas; i++) {
      if (pessoas[i] != null && pessoas[i].getNome().equals(pessoaAntiga.getNome())) {
        pessoas[i] = novaPessoa;
        return;
      }
    }
  }

  // getPessoaByName(String): retorna uma pessoa baseada em seu nome.
  public Pessoa getPessoaByName(String nome) {
    for (int i = 0; i < quantidadePessoasCadastradas; i++) {
      if (pessoas[i] != null && pessoas[i].getNome().equalsIgnoreCase(nome)) {
        return pessoas[i];
      }
    }
    return null;
  }

  // getAll(): retorna todo o vetor de pessoas.
  public Pessoa[] getAll() {
    Pessoa[] pessoasValidas = new Pessoa[quantidadePessoasCadastradas];
    for (int i = 0; i < quantidadePessoasCadastradas; i++) {
      pessoasValidas[i] = pessoas[i];
    }
    return pessoasValidas;
  }

  // removeAll(): apaga todo o vetor de pessoas.
  public void removeAll() {
    for (int i = 0; i < quantidadePessoasCadastradas; i++) {
      pessoas[i] = null;
    }
    quantidadePessoasCadastradas = 0;
  }

  /////////////////////// MÉTODOS DE COMPORTAMENTO//////////////////////////
  // size(): retorna o número de elementos do dataset.
  public int size() {
    return quantidadePessoasCadastradas;
  }

  // maxAltura(): retorna a maior altura.
  public float maxAltura() {
    if (quantidadePessoasCadastradas == 0) {
      return 0;
    }
    float alturaMaxima = pessoas[0].getAltura();
    for (int i = 1; i < quantidadePessoasCadastradas; i++) {
      if (pessoas[i].getAltura() > alturaMaxima) {
        alturaMaxima = pessoas[i].getAltura();
      }
    }
    return alturaMaxima;
  }

  // minAltura(): retorna a menor altura.
  public float minAltura() {
    if (quantidadePessoasCadastradas == 0) {
      return 0;
    }
    float alturaMinima = pessoas[0].getAltura();
    for (int i = 1; i < quantidadePessoasCadastradas; i++) {
      if (pessoas[i].getAltura() < alturaMinima) {
        alturaMinima = pessoas[i].getAltura();
      }
    }
    return alturaMinima;
  }

  // avgAltura(): retorna a altura média.
  public float avgAltura() {
    if (quantidadePessoasCadastradas == 0) {
      return 0;
    }
    float mediaAltura = 0.0f;
    for (int i = 0; i < quantidadePessoasCadastradas; i++) {
      mediaAltura += pessoas[i].getAltura();
    }
    return mediaAltura / quantidadePessoasCadastradas;
  }

  // maxPeso(): retorna a maior peso.
  public int maxPeso() {
    if (quantidadePessoasCadastradas == 0) {
      return 0;
    }
    int pesoMaximo = pessoas[0].getPeso();
    for (int i = 1; i < quantidadePessoasCadastradas; i++) {
      if (pessoas[i].getPeso() > pesoMaximo) {
        pesoMaximo = pessoas[i].getPeso();
      }
    }
    return pesoMaximo;
  }

  // minPeso(): retorna a menor peso.
  public int minPeso() {
    if (quantidadePessoasCadastradas == 0) {
      return 0;
    }
    int pesoMinimo = pessoas[0].getPeso();
    for (int i = 1; i < quantidadePessoasCadastradas; i++) {
      if (pessoas[i].getPeso() < pesoMinimo) {
        pesoMinimo = pessoas[i].getPeso();
      }
    }
    return pesoMinimo;
  }

  // avgPeso(): retorna a altura média.
  public int avgPeso() {
    if (quantidadePessoasCadastradas == 0) {
      return 0;
    }
    int mediaPeso = 0;
    for (int i = 0; i < quantidadePessoasCadastradas; i++) {
      mediaPeso += pessoas[i].getPeso();
    }
    return mediaPeso / quantidadePessoasCadastradas;
  }

  // percentAdult(): float: retorna a porcentagem de pessoas maiores de idade na coleção. Para
  // manter a alta coesão e baixo acoplamento, pode ser necessário alterar a classe Pessoa.

  private float calcularPercentual(int quantidade) {
    if (quantidadePessoasCadastradas == 0) {
      return 0;
    }
    return ((float) quantidade / quantidadePessoasCadastradas) * 100;
  }

  public float percentAdult() {
    int totalAdultos = 0;
    for (int i = 0; i < quantidadePessoasCadastradas; i++) {
      if (pessoas[i].getAge() >= 18) {
        totalAdultos++;
      }
    }
    return calcularPercentual(totalAdultos);
  }

  // percentEstadoCivil(enum EstadoCivil): retorna a porcentagem de pessoas com o estado civil
  // determinado pelo parâmetro.
  public float percentEstadoCivil(EstadoCivil estadoCivil) {
    int totalPorEstadoCivil = 0;
    for (int i = 0; i < quantidadePessoasCadastradas; i++) {
      if (pessoas[i].getEstadoCivil().equals(estadoCivil)) {
        totalPorEstadoCivil++;
      }
    }
    return calcularPercentual(totalPorEstadoCivil);
  }

  // modeEstadoCivil(): retorna o estado civil mais frequente.
  public EstadoCivil modeEstadoCivil() {
    int[] contador = new int[5];

    for (int i = 0; i < quantidadePessoasCadastradas; i++) {
      EstadoCivil estado = pessoas[i].getEstadoCivil();
      if (estado == EstadoCivil.CASADO) {
        contador[0]++;
      } else if (estado == EstadoCivil.DIVORCIADO) {
        contador[1]++;
      } else if (estado == EstadoCivil.SEPARADO) {
        contador[2]++;
      } else if (estado == EstadoCivil.SOLTEIRO) {
        contador[3]++;
      } else if (estado == EstadoCivil.VIUVO) {
        contador[4]++;
      }
    }

    int max = contador[0];
    EstadoCivil maisComum = EstadoCivil.CASADO;

    if (contador[1] > max) {
      max = contador[1];
      maisComum = EstadoCivil.DIVORCIADO;
    }
    if (contador[2] > max) {
      max = contador[2];
      maisComum = EstadoCivil.SEPARADO;
    }
    if (contador[3] > max) {
      max = contador[3];
      maisComum = EstadoCivil.SOLTEIRO;
    }
    if (contador[4] > max) {
      max = contador[4];
      maisComum = EstadoCivil.VIUVO;
    }

    return maisComum;
  }

  // percentEscolaridade(enum  Escolaridade): retorna a porcentagem de pessoas com a formação
  // acadêmica determinada pelo parâmetro.+
  // modeEscolaridade(): retorna a formação acadêmica mais frequente.
  public float percentEscolaridade(Escolaridade escolaridade) {
    int totalPorEscolaridade = 0;
    for (int i = 0; i < quantidadePessoasCadastradas; i++) {
      if (pessoas[i].getEscolaridade().equals(escolaridade)) {
        totalPorEscolaridade++;
      }
    }
    return calcularPercentual(totalPorEscolaridade);
  }

  public Escolaridade modeEscolaridade() {
    int[] contador = new int[6];

    for (int i = 0; i < quantidadePessoasCadastradas; i++) {
      Escolaridade escolaridade = pessoas[i].getEscolaridade();
      if (escolaridade == Escolaridade.FUNDAMENTAL) {
        contador[0]++;
      } else if (escolaridade == Escolaridade.NENHUMA) {
        contador[1]++;
      } else if (escolaridade == Escolaridade.FUNDAMENTAL) {
        contador[2]++;
      } else if (escolaridade == Escolaridade.MEDIO) {
        contador[3]++;
      } else if (escolaridade == Escolaridade.SUPERIOR) {
        contador[4]++;

      } else if (escolaridade == Escolaridade.POS_GRADUACAO) {
        contador[5]++;
      }
    }

    int max = contador[0];
    Escolaridade maisComum = Escolaridade.FUNDAMENTAL;

    if (contador[1] > max) {
      max = contador[1];
      maisComum = Escolaridade.NENHUMA;
    }
    if (contador[2] > max) {
      max = contador[2];
      maisComum = Escolaridade.FUNDAMENTAL;
    }
    if (contador[3] > max) {
      max = contador[3];
      maisComum = Escolaridade.MEDIO;
    }
    if (contador[4] > max) {
      max = contador[4];
      maisComum = Escolaridade.SUPERIOR;
    }
    if (contador[5] > max) {
      max = contador[5];
      maisComum = Escolaridade.POS_GRADUACAO;
    }

    return maisComum;
  }

  // percentMoradia(enum  Moradia): retorna a porcentagem de pessoas com a moradia determinada pelo
  // parâmetro.
  // modeMoradia(): retorna a Moradia mais frequente.

  public float percentMoradia(Moradia moradia) {
    int totalPorMoradia = 0;
    for (int i = 0; i < quantidadePessoasCadastradas; i++) {
      if (pessoas[i].getMoradia().equals(moradia)) {
        totalPorMoradia++;
      }
    }
    return calcularPercentual(totalPorMoradia);
  }

  public Moradia modeMoradia() {
    int[] contador = new int[3];

    for (int i = 0; i < quantidadePessoasCadastradas; i++) {
      Moradia moradia = pessoas[i].getMoradia();
      if (moradia == Moradia.COM_FAMILIA) {
        contador[0]++;
      } else if (moradia == Moradia.ALUGUEL) {
        contador[1]++;
      } else if (moradia == Moradia.CASA_PROPRIA) {
        contador[2]++;
      }
    }

    int max = contador[0];
    Moradia maisComum = Moradia.COM_FAMILIA;

    if (contador[1] > max) {
      max = contador[1];
      maisComum = Moradia.ALUGUEL;
    }
    if (contador[2] > max) {
      max = contador[2];
      maisComum = Moradia.CASA_PROPRIA;
    }

    return maisComum;
  }

  //
  // percentHobby(): retorna a porcentagem de pessoas com hobbies.

  public float percentHobby() {
    int totalHobby = 0;
    for (int i = 0; i < quantidadePessoasCadastradas; i++) {
      if (!(pessoas[i].getHobby().equals(Hobby.NENHUM))) {
        totalHobby++;
      }
    }
    return calcularPercentual(totalHobby);
  }

  // percentFeliz(): retorna a porcentagem de pessoas felizes.
  public float percentFeliz() {
    int totalFeliz = 0;
    for (int i = 0; i < quantidadePessoasCadastradas; i++) {
      if (pessoas[i].isFeliz()) {
        totalFeliz++;
      }
    }
    return calcularPercentual(totalFeliz);
  }
}
