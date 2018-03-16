package projeto;

import java.io.*;
import java.lang.*;
import java.util.*;

public class Arquivo {

	private File arquivo;
	ControllerTutor controlador;
	ControllerAluno controle;
	/**
	 * motodo void que cria o arquivo
	 */
	public void openFile() {
		try {
			this.arquivo = new File("Arquivo.txt");
		} catch (Exception e) {
			System.out.println("Error Detected");
		}
	}
	/**
	 * metodo que escreve no arquivo
	 */
	public void addRecords() {
		openFile();
		FileWriter fw;
		try {
			fw = new FileWriter(arquivo, true);
			BufferedWriter bw = new BufferedWriter(fw);
			for (Tutor tutor : controlador.getTutores()) {
				bw.write(tutor.toString());
				bw.newLine();
			}
			for (Aluno aluno : controle.getAlunos()) {
				bw.write(aluno.toString());
				bw.newLine();
			}
			bw.close();
			fw.close();
		} catch (IOException e) {

		}

	}
	/**
	 * metodo que lê o arquivo
	 */
	public void Read() {
		// faz a leitura do arquivo
		try {
			FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fr);
			// enquanto houver mais linhas
			while (br.ready()) {
				// lê a proxima linha
				String linha = br.readLine();
				// faz algo com a linha
				System.out.println(linha);
			}
			br.close();
			fr.close();
		} catch (IOException e) {
		}

	}

}
