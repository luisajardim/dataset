

import static org.junit.jupiter.api.Assertions.assertEquals;

import br.lpm.business.Pessoa;
import org.junit.jupiter.api.Test;

public class PessoaTest {
  @Test
  void testSetNome() {
    Pessoa pessoa= new Pessoa(); 
    pessoa.setNome("Luísa");
    assertEquals( "Luísa", pessoa.getNome());
  }

  @Test 
  void testSetNomeInvalido(){
    Pessoa pessoa= new Pessoa();
    pessoa.setNome("12345");
    assertEquals(null, pessoa.getNome());
  }
  @Test 
  void testSetRenda(){
    Pessoa pessoa= new Pessoa();
    pessoa.setRenda( 362);
    assertEquals(362, pessoa.getRenda());
  }

  @Test
  void testSetRendaInvalido() {
    Pessoa pessoa = new Pessoa();
    pessoa.setRenda(-3);
    assertEquals(0, pessoa.getRenda());
  }
  @Test 
  void testSetAltura(){
    Pessoa pessoa = new Pessoa();
    pessoa.setAltura(1.72f);
    assertEquals(1.72f, pessoa.getAltura());
  }

  @Test
  void testSetAlturaMenor() {
    Pessoa pessoa = new Pessoa();
    pessoa.setAltura(-1.72f);
    assertEquals(0, pessoa.getAltura());
  }

  @Test
  void testSetAlturaMaior() {
    Pessoa pessoa = new Pessoa();
    pessoa.setAltura(3.0f);
    assertEquals(0, pessoa.getAltura());
  }

  @Test
  void testSetPeso() {
    Pessoa pessoa = new Pessoa();
    pessoa.setPeso(65);
    assertEquals(65, pessoa.getPeso());
  }

  @Test
  void testSetPesoMenor() {
    Pessoa pessoa = new Pessoa();
    pessoa.setPeso(-34);
    assertEquals(0, pessoa.getPeso());
  }

  @Test
  void testSetPesoMaior() {
    Pessoa pessoa = new Pessoa();
    pessoa.setPeso(800);
    assertEquals(0, pessoa.getPeso());
  }
  }


