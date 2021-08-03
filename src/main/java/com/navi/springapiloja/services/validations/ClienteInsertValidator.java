package com.navi.springapiloja.services.validations;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.navi.springapiloja.domain.enums.TipoCliente;
import com.navi.springapiloja.dto.ClienteNewDTO;
import com.navi.springapiloja.resources.exceptions.FieldMessage;
import com.navi.springapiloja.services.validations.utils.BR;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
	@Override
	public void initialize(ClienteInsert ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		if (objDto.getTipo() == null) {
			list.add(new FieldMessage("tipo", "Esse campo não pode ser nulo"));
		}
		
		if (objDto.getTipo() == TipoCliente.PESSOAFISICA.getCodigo() && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CPF Inválido."));
		}
		if (objDto.getTipo() == TipoCliente.PESSOAJURIDICA.getCodigo() && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
			list.add(new FieldMessage("cpfOuCnpj", "CNPJ Inválido."));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}