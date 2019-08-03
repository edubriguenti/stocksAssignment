package com.payconiq.stock.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * Stock
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2019-08-03T16:32:05.573Z[GMT]")
public class Stock   {
  @JsonProperty("id")
  private Integer id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("currentPrice")
  private BigDecimal currentPrice = null;

  @JsonProperty("lastUpdate")
  private String lastUpdate = null;

  public Stock id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * unique identifier of a stock
   * @return id
  **/
  @ApiModelProperty(example = "1234", value = "unique identifier of a stock")

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Stock name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the product
   * @return name
  **/
  @ApiModelProperty(example = "Book", value = "Name of the product")

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Stock currentPrice(BigDecimal currentPrice) {
    this.currentPrice = currentPrice;
    return this;
  }

  /**
   * Price of the product
   * @return currentPrice
  **/
  @ApiModelProperty(example = "10.22", value = "Price of the product")

  @Valid
  public BigDecimal getCurrentPrice() {
    return currentPrice;
  }

  public void setCurrentPrice(BigDecimal currentPrice) {
    this.currentPrice = currentPrice;
  }

  public Stock lastUpdate(String lastUpdate) {
    this.lastUpdate = lastUpdate;
    return this;
  }

  /**
   * Get lastUpdate
   * @return lastUpdate
  **/
  @ApiModelProperty(example = "2017-07-21T17:32:28Z", value = "")

  public String getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(String lastUpdate) {
    this.lastUpdate = lastUpdate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Stock stock = (Stock) o;
    return Objects.equals(this.id, stock.id) &&
        Objects.equals(this.name, stock.name) &&
        Objects.equals(this.currentPrice, stock.currentPrice) &&
        Objects.equals(this.lastUpdate, stock.lastUpdate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, currentPrice, lastUpdate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Stock {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    currentPrice: ").append(toIndentedString(currentPrice)).append("\n");
    sb.append("    lastUpdate: ").append(toIndentedString(lastUpdate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
