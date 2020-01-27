package br.com.rsinet.hub_TDD.Excel;

public class MassaDeDadosPesqHome {
	public String HP_Pro() throws Exception {
	ExcelUtils.setExcelFile(Diretorio.Path_TestData + Diretorio.File_TestData, "BuscaHome");
	String HP_Pro = ExcelUtils.getCellData(0, 0);
	return HP_Pro;
	}
}
