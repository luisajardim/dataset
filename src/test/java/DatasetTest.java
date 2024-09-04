

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.lpm.business.Dataset;
import br.lpm.business.Escolaridade;
import br.lpm.business.EstadoCivil;
import br.lpm.business.Genero;
import br.lpm.business.Hobby;
import br.lpm.business.Moradia;
import br.lpm.business.Pessoa;

public class DatasetTest {

  private static Dataset dataset;
  private static Pessoa pessoa1;
  private static Pessoa pessoa2;
  private static Pessoa pessoa3;

  @BeforeEach
  public void setUp() throws Exception {
    dataset = new Dataset();

    pessoa1 =
        new Pessoa(
            "Luísa",
            LocalDate.of(2002, 05, 8),
            Genero.FEMININO,
            1.65f,
            68,
            1000.00f,
            "Araçuaí",
            Hobby.LIVRO,
            EstadoCivil.SOLTEIRO,
            Escolaridade.MEDIO,
            false,
            Moradia.COM_FAMILIA);

    pessoa2 =
        new Pessoa(
            "Leonardo",
            LocalDate.of(2002,03, 9),
            Genero.MASCULINO,
            1.70f,
            65,
            60000.00f,
            "Belo Horizonte",
            Hobby.GAME,
            EstadoCivil.CASADO,
            Escolaridade.SUPERIOR,
            true,
            Moradia.COM_FAMILIA);

    pessoa3 =
        new Pessoa(
            "Izabella",
            LocalDate.of(2002, 05, 03),
            Genero.FEMININO,
            1.68f,
            55,
            26000.00f,
            "Nova Lima",
            Hobby.LIVRO,
            EstadoCivil.CASADO,
            Escolaridade.SUPERIOR,
            true,
            Moradia.ALUGUEL);
  }

  @Test
  @DisplayName("Teste de addPessoa")
  public void testAddPessoa() {
    dataset.addPessoa(pessoa1);
    assertEquals(1, dataset.size(), "");

    dataset.addPessoa(pessoa2);
    assertEquals(2, dataset.size());

    dataset.addPessoa(null);
    assertEquals(2, dataset.size());

    dataset.addPessoa(pessoa2);
    assertEquals(2, dataset.size());

    dataset.removeAll();
    assertEquals(0, dataset.size());

    dataset.addPessoa(null);
    assertEquals(0, dataset.size());
  }

  @Test
  @DisplayName("Teste de removePessoa")
  public void testRemovePessoa() {
    dataset.addPessoa(pessoa1);
    dataset.addPessoa(pessoa3);

    dataset.removePessoa(pessoa1);
    assertEquals(1, dataset.size());

    dataset.removePessoa(pessoa2);
    assertEquals(1, dataset.size());

    dataset.removePessoa(pessoa3);
    assertEquals(0, dataset.size());
  }

  @Test
  @DisplayName("Teste de removePessoaByName")
  void testRemovePessoaByName() {
    dataset.addPessoa(pessoa1);
    dataset.addPessoa(pessoa2);

    dataset.removePessoaByName("Luísa");
    assertEquals(1, dataset.size());

    dataset.removePessoaByName("Leonardo");
    assertEquals(0, dataset.size());

    dataset.removePessoaByName("Izabella");
    assertEquals(0, dataset.size());
  }

  @Test
  @DisplayName("Teste do replacePessoa")
  void testReplacePessoa() {
    pessoa1.setNome("Luísa");
    pessoa2.setNome("Leonardo");
    pessoa3.setNome("Izabella");

    dataset.addPessoa(pessoa1);
    dataset.addPessoa(pessoa2);

    dataset.replacePessoa(pessoa1, pessoa3);
    assertEquals(
        null,
        dataset.getPessoaByName("Luísa"),
        "A pessoa com nome 'Luísa' deveria ter sido substituída");

    assertEquals(
        pessoa3,
        dataset.getPessoaByName("Izabella"),
        "A pessoa com nome 'Izabella' deveria estar na lista.");
  }

  @Test
  @DisplayName("Teste de getPessoaByName")
  void testGetPessoaByName() {
    dataset.addPessoa(pessoa2);

    assertEquals(pessoa2, dataset.getPessoaByName("Leonardo") );

    assertEquals(
        null, dataset.getPessoaByName("Izabella"));
  }

  @Test
  @DisplayName("Teste de getAll")
  void testGetAll() {
    dataset.removeAll();
    Pessoa[] pessoas = dataset.getAll();
    assertEquals(0, pessoas.length);

    dataset.addPessoa(pessoa2);
    Pessoa[] pessoas1 = dataset.getAll();
    assertEquals(1, pessoas1.length);
    assertEquals(pessoa2, pessoas1[0]);
  }

  @Test
  @DisplayName("Teste de removeAll")
  void testRemoveAll() {
    dataset.addPessoa(pessoa1);
    dataset.addPessoa(pessoa2);

    dataset.removeAll();
    Pessoa[] pessoas = dataset.getAll();
    assertEquals(0, pessoas.length);
  }

  @Test
  @DisplayName("Teste de size")
  void testSize() {
    dataset.addPessoa(pessoa1);
    assertEquals(1, dataset.size());
    dataset.addPessoa(pessoa2);
    assertEquals(2, dataset.size());
    dataset.removePessoa(pessoa1);
    assertEquals(1, dataset.size());
    dataset.removeAll();
    assertEquals(0, dataset.size());
  }

  @Test
  @DisplayName("Teste de maxAltura")
  void testMaxAltura() {
    dataset.addPessoa(pessoa2);
    assertEquals(1.70f, dataset.maxAltura(), 0.01f);

    dataset.addPessoa(pessoa1);
    assertEquals(1.70f, dataset.maxAltura(), 0.01f);

    dataset.addPessoa(pessoa3);
    assertEquals(1.70f, dataset.maxAltura(), 0.01f);
  }

  @Test
  @DisplayName("Teste de minAltura")
  void testMinAltura() {
    dataset.addPessoa(pessoa3);
    assertEquals(1.68f, dataset.minAltura(), 0.01f);

    dataset.addPessoa(pessoa2);
    assertEquals(1.68f, dataset.minAltura());

    dataset.addPessoa(pessoa1);
    assertEquals(1.65f, dataset.minAltura(), 0.01f);
  }

  @Test
  @DisplayName("Teste de avgAltura")
  void testAvgAltura() {
    dataset.addPessoa(pessoa1);
    dataset.addPessoa(pessoa2);
    dataset.addPessoa(pessoa3);

    assertEquals(1.67F, dataset.avgAltura(), 0.01f);
  }

  @Test
  @DisplayName("Teste de maxPeso")
  void testMaxPeso() {
    dataset.addPessoa(pessoa2);
    assertEquals(65, dataset.maxPeso(), "Peso máximo deve ser 65kg");

    dataset.addPessoa(pessoa1);
    assertEquals(68, dataset.maxPeso(), "novo peso máximo: 68kg");

    dataset.addPessoa(pessoa3);
    assertEquals(68, dataset.maxPeso(), "Peso máximo finalnão se altera e é 68kg");
  }

  @Test
  @DisplayName("Teste de minPeso")
  void testMinPeso() {
    dataset.addPessoa(pessoa2);
    assertEquals(65, dataset.minPeso());

    dataset.addPessoa(pessoa3);
    assertEquals(55, dataset.minPeso());

    dataset.addPessoa(pessoa1);
    assertEquals(55, dataset.minPeso());
  }

  @Test
  @DisplayName("Teste de avgPeso")
  void testAvgPeso() {
    dataset.removeAll();
    assertEquals(0, dataset.avgPeso());
    dataset.addPessoa(pessoa1);
    dataset.addPessoa(pessoa2);
    dataset.addPessoa(pessoa3);

    assertEquals(62, dataset.avgPeso());
  }

  @Test
  @DisplayName("Teste de percentAdult")
  void testPercentAdult() {
    dataset.addPessoa(pessoa2);
    dataset.addPessoa(pessoa3);
    dataset.addPessoa(pessoa1);

    assertEquals(100, dataset.percentAdult());

    dataset.removePessoa(pessoa1);
    assertEquals(100, dataset.percentAdult());
  }

  @Test
  @DisplayName("Teste de percentEstadoCivil")
  public void testPercentEstadoCivil() {
    dataset.addPessoa(pessoa1);
    dataset.addPessoa(pessoa2);
    dataset.addPessoa(pessoa3);
    assertEquals(
        33.33f,
        dataset.percentEstadoCivil(EstadoCivil.SOLTEIRO),
        0.01f);
  }

  @Test
  @DisplayName("Teste de modeEstadoCivil")
  public void testModeEstadoCivil() {
    dataset.addPessoa(pessoa1);
    dataset.addPessoa(pessoa2);
    dataset.addPessoa(pessoa3);
    assertEquals(
        EstadoCivil.CASADO,
        dataset.modeEstadoCivil());
  }

  @Test
  @DisplayName("Teste de percentEscolaridade")
  public void testPercentEscolaridade() {
    dataset.addPessoa(pessoa1);
    dataset.addPessoa(pessoa2);
    dataset.addPessoa(pessoa3);
    assertEquals(
        33.33f,
        dataset.percentEscolaridade(Escolaridade.MEDIO),
        0.01f);
  }

  @Test
  @DisplayName("Teste de modeEscolaridade")
  public void testModeEscolaridade() {
    dataset.addPessoa(pessoa1);
    dataset.addPessoa(pessoa2);
    dataset.addPessoa(pessoa3);
    assertEquals(
        Escolaridade.SUPERIOR,
        dataset.modeEscolaridade());
  }

  @Test
  @DisplayName("Teste de percentMoradia")
  public void testPercentMoradia() {
    dataset.addPessoa(pessoa1);
    dataset.addPessoa(pessoa2);
    dataset.addPessoa(pessoa3);
    assertEquals(
        33.33f,
        dataset.percentMoradia(Moradia.ALUGUEL),
        0.01f);

    assertEquals(
        66.66f,
        dataset.percentMoradia(Moradia.COM_FAMILIA),
        0.01f);
  }

  @Test
  @DisplayName("Teste de modeMoradia")
  public void testModeMoradia() {
    dataset.addPessoa(pessoa1);
    dataset.addPessoa(pessoa2);
    dataset.addPessoa(pessoa3);
    assertEquals(
        Moradia.COM_FAMILIA,
        dataset.modeMoradia());
  }

  @Test
  @DisplayName("Teste de percentHobby")
  public void testPercentHobby() {
    dataset.addPessoa(pessoa1);
    dataset.addPessoa(pessoa2);
    dataset.addPessoa(pessoa3);
    assertEquals(
        100.0f,
        dataset.percentHobby(),
        0.01f);
  }

  @Test
  @DisplayName("Teste de percentFeliz")
  public void testPercentFeliz() {
    dataset.addPessoa(pessoa1);
    dataset.addPessoa(pessoa2);
    dataset.addPessoa(pessoa3);
    assertEquals(
        66.66f,
        dataset.percentFeliz(),
        0.01f);
  }
}
