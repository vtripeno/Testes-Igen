function clica(value) {

	if (value == "Gravar") {
		$("#control").val("AdicionarCliente")
		$('#id').attr("disabled", true);
		$('#nome').attr("disabled", false);
		$('#cpf').attr("disabled", false);
		$('#email').attr("disabled", false);
		$("#btAcao").val("Gravar");
	} else if (value == "Alterar") {
		$("#control").val("AlterarCliente")
		$('#id').attr("disabled", false);
		$('#nome').attr("disabled", false);
		$('#cpf').attr("disabled", false);
		$('#email').attr("disabled", false);
		$("#btAcao").val("Alterar");

	} else if (value == "Excluir") {
		$("#control").val("ExcluirCliente")
		$('#id').attr("disabled", false);
		$('#nome').attr("disabled", true);
		$('#cpf').attr("disabled", true);
		$('#email').attr("disabled", true);
		$("#btAcao").val("Excluir");
	}

};

