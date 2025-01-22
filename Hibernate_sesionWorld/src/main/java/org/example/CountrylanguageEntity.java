package org.example;

import java.math.BigDecimal;

public class CountrylanguageEntity {
    private String countryCode;
    private String language;
    private String isOfficial;
    private BigDecimal percentage;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getIsOfficial() {
        return (String) isOfficial;
    }

    public void setIsOfficial(String isOfficial) {
        this.isOfficial = isOfficial;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CountrylanguageEntity that = (CountrylanguageEntity) o;

        if (countryCode != null ? !countryCode.equals(that.countryCode) : that.countryCode != null) return false;
        if (language != null ? !language.equals(that.language) : that.language != null) return false;
        if (isOfficial != null ? !isOfficial.equals(that.isOfficial) : that.isOfficial != null) return false;
        if (percentage != null ? !percentage.equals(that.percentage) : that.percentage != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = countryCode != null ? countryCode.hashCode() : 0;
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (isOfficial != null ? isOfficial.hashCode() : 0);
        result = 31 * result + (percentage != null ? percentage.hashCode() : 0);
        return result;
    }
}
