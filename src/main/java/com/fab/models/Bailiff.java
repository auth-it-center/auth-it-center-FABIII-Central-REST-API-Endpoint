package com.fab.models;

public interface Bailiff {

    public Long getId();

    public void setId(Long id);

    public String getName();

    public void setName(String name);

    public String getAddress();

    public void setAddress(String address);

    public String getPostalCode();

    public void setPostalCode(String postalCode);

    public String getMunicipality();

    public void setMunicipality(String municipality);

    public String getTel();

    public void setTel(String tel);

    public String getLang();

    public void setLang(String lang);

    public boolean getIsSetLang();

    public void setIsSetLang(boolean setLang);

    public String getCountry();

    public void setCountry(String country);

    public boolean getIsSetCountry();

    public void setIsSetCountry(boolean setCountry);

}
