/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mackenzie.caixaeletronico.model.conta;

/**
 *
 * @author Vinicius
 */
public class Cliente {
    private String nome;
    private String tipoPessoa;
    private String logradouro;
    private String cep;
    private String bairro;
    private String cidade;
    private String estado;
    private String documento;

    @Override
    public boolean equals(Object o){
        if (o!=null && o instanceof Cliente){
            Cliente c = (Cliente) o;
            if (c.getDocumento().equalsIgnoreCase(this.getDocumento())){
                return true;
            }
        }
        return false;
    }
    
    @Override
    public String toString(){
        return String.valueOf(this.nome);
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }
}
