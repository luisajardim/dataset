package br.lpm.main;

import br.lpm.business.Dataset;
import br.lpm.business.Escolaridade;
import br.lpm.business.EstadoCivil;
import br.lpm.business.Genero;
import br.lpm.business.Hobby;
import br.lpm.business.Moradia;
import br.lpm.business.Pessoa;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import org.jfree.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class Main {

  public static Dataset dataset = new Dataset();

  public static void main(String[] args) {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    while (true) {
      Pessoa pessoa = new Pessoa();
      String valor;

      valor = JOptionPane.showInputDialog("Nome:");
      if (valor != null && !valor.trim().isEmpty()) {
        pessoa.setNome(valor);
      }

      valor = JOptionPane.showInputDialog("Data de nascimento (dd/MM/yyyy):");
      if (valor != null && !valor.trim().isEmpty()) {
        LocalDate dataNascimento = LocalDate.parse(valor, formatter);
        pessoa.setDataNascimento(dataNascimento);
      }

      valor =
          JOptionPane.showInputDialog("Gênero (MASCULINO, FEMININO, NAO_BINARIO, NAO_RESPONDER):");
      if (valor != null && !valor.trim().isEmpty()) {
        pessoa.setGenero(Genero.valueOf(valor.trim().toUpperCase()));
      }

      valor = JOptionPane.showInputDialog("Altura:");
      if (valor != null && !valor.trim().isEmpty()) {
        pessoa.setAltura(Float.parseFloat(valor));
      }

      valor = JOptionPane.showInputDialog("Peso:");
      if (valor != null && !valor.trim().isEmpty()) {
        pessoa.setPeso(Integer.parseInt(valor));
      }

      valor = JOptionPane.showInputDialog("Renda:");
      if (valor != null && !valor.trim().isEmpty()) {
        pessoa.setRenda(Float.parseFloat(valor));
      }

      valor = JOptionPane.showInputDialog("Naturalidade:");
      if (valor != null && !valor.trim().isEmpty()) {
        pessoa.setNaturalidade(valor);
      }

      valor =
          JOptionPane.showInputDialog(
              "Hobby (ARTE, ESPORTE, CINEMA, LIVRO, MÚSICA, CULINÁRIA, GAME, NENHUMA):");
      if (valor != null && !valor.trim().isEmpty()) {
        pessoa.setHobby(Hobby.valueOf(valor.trim().toUpperCase()));
      }

      valor =
          JOptionPane.showInputDialog(
              "Estado civil (SOLTEIRO, CASADO, VIUVO, SEPARADO, DIVORCIADO):");
      if (valor != null && !valor.trim().isEmpty()) {
        pessoa.setEstadoCivil(EstadoCivil.valueOf(valor.trim().toUpperCase()));
      }

      valor =
          JOptionPane.showInputDialog(
              "Grau de escolaridade (NENHUMA, FUNDAMENTAL, MEDIO, SUPERIOR, POS_GRADUACAO):");
      if (valor != null && !valor.trim().isEmpty()) {
        pessoa.setEscolaridade(Escolaridade.valueOf(valor.trim().toUpperCase()));
      }

      valor = JOptionPane.showInputDialog("Feliz (true/false):");
      if (valor != null && !valor.trim().isEmpty()) {
        pessoa.setFeliz(Boolean.parseBoolean(valor));
      }

      valor = JOptionPane.showInputDialog("Moradia (COM_FAMILIA, ALUGUEL, CASA_PROPRIA):");
      if (valor != null && !valor.trim().isEmpty()) {
        pessoa.setMoradia(Moradia.valueOf(valor.trim().toUpperCase()));
      }

      dataset.addPessoa(pessoa);

      JOptionPane.showMessageDialog(null, pessoa.toString());

      int continuarCadastro =
          JOptionPane.showConfirmDialog(
              null, "Deseja cadastrar outra pessoa?", "Continuar?", JOptionPane.YES_NO_OPTION);
      if (continuarCadastro == JOptionPane.NO_OPTION) {
        break;
      }
    }
    histogramFormacaoAcadêmica();
    pieMoradia();
  }

  public static void histogramFormacaoAcadêmica() {
    JFrame screen = new JFrame();
    screen.setTitle("histograma");
    screen.setVisible(true);
    screen.setSize(800, 500);
    // -----------------------------------
    DefaultCategoryDataset histogramDataset = new DefaultCategoryDataset();
    for (Escolaridade es : Escolaridade.values()) {
      histogramDataset.addValue(dataset.percentEscolaridade(es), es, "");
    }

    JFreeChart grafico =
        ChartFactory.createBarChart3D(
            "Histograma das Formações Acadêmicas",
            "Categorias de Escolaridade",
            "Porcentagem",
            histogramDataset,
            PlotOrientation.VERTICAL,
            true,
            true,
            false);
    // -------------------------------------------------
    ChartPanel painel = new ChartPanel(grafico);
    screen.add(painel);
    screen.setVisible(true);
  }

  // ------------------------------------------------------------------------------

  public static void pieMoradia() {
    JFrame screen = new JFrame();
    screen.setTitle("Pie");
    screen.setVisible(true);
    screen.setSize(800, 500);
    // -----------------------------------
    DefaultPieDataset pieChartDataset = new DefaultPieDataset();
    for (Moradia hb : Moradia.values()) {
      pieChartDataset.setValue(hb, dataset.percentMoradia(hb));
    }

    JFreeChart grafico =
        ChartFactory.createPieChart3D(
            "Piechart dos tipos de moradia", pieChartDataset, true, true, false);
    // -------------------------------------------------
    ChartPanel painel = new ChartPanel(grafico);
    screen.add(painel);
    screen.setVisible(true);
  }
}
