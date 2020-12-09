package fr.training.samples.spring.shop.exposition.customer.rest;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@ApiModel(value = "Customer",description = "contient les informations d'un client")
@Validated
public class CustomerLightDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	private String password;


	public CustomerLightDto() {

	}


	public CustomerLightDto(final String name, final String password) {
		super();
		this.name = name;
		this.password = password;
	}

	@ApiModelProperty(value="Customer name",example= "toto lolo",required = true)
	@NotBlank
	public String getName() {
		return name;
	}

	@ApiModelProperty(value="mot de passe du client",required = true)
	@NotBlank
	public String getPassword() {
		return password;
	}

	/**
	 * @param name
	 */
	public void setName(final String name) {
		this.name = name;
	}

	/**
	 * @param password
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

}
