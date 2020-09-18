import org.junit.jupiter.api.Test;

import sistemas.SistemaControleAcademico;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SistemaControleAcademicoTeste {

    SistemaControleAcademico sistema = new SistemaControleAcademico();

    @Test
    public void validarCriarAluno() {
        String resultadoEsperado = new String("{matricula: '0012462', nome: 'Thairam Michel'}");
        assertEquals(sistema.criarAluno("0012462", "Thairam Michel"), resultadoEsperado);
    }

    @Test
    public void validarCriarProfessor() {
        String resultadoEsperado = new String("{matricula: '1215841', nome: 'Sabrina', dataAdmissao: '01/01/2014'}");
        assertEquals(sistema.criarProfessor("1215841", "Sabrina", "01/01/2014"), resultadoEsperado);
    }

    @Test
    public void validarCriarDisciplina() {
        String resultadoEsperado = new String("{id: 1, descricao: 'MAP'}");
        assertEquals(sistema.criarDisciplina("MAP"), resultadoEsperado);
    }

    @Test
    public void validarObterHistoricoDoAluno() {
        String resultadoEsperado = new String("{matriculaAluno:  '142564', historico: [...]}");
        assertEquals(sistema.obterHistoricoDoAluno("142564"), resultadoEsperado);
    }

    @Test
    public void validarObterRdmDoAluno() {
        String resultadoEsperado = new String("{matriculaAluno: '142564', rdm: [...]}");
        assertEquals(sistema.obterRdmDoAluno("142564"), resultadoEsperado);
    }

    @Test
    public void validarAlocarProfessorParaDisciplina() {
        String resultadoEsperado = new String("{professor: '165478', idDisciplinaMinistrada: '12'}");
        assertEquals(sistema.alocarProfessorParaDisciplina("165478", 12), resultadoEsperado);
    }

    @Test
    public void validarObterDisciplinasDoProfessor() {
        String resultadoEsperado = new String("{{id: 1, descricao: 'disciplina1'}, {id: 5, descricao: 'discplina5'}}");
        assertEquals(sistema.obterDisciplinasDoProfessor("1248741"), resultadoEsperado);
    }

    @Test
    public void validarObterTempoDeCasaDoProfessor() {
        String resultadoEsperado = new String("{tempo: 750}");
        assertEquals(sistema.obterTempoDeCasaDoProfessor("1248741"), resultadoEsperado);
    }
}
