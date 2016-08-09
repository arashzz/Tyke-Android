package com.toranj.tyke.models;

import java.util.Date;

/**
 * Created by arash on 7/24/16.
 */
public class Lottery extends Base {
    String name;
    String brandName;
    String brandId;
    String description;
    Date lotteryDate;
    Date spendingValidityStartDate;
    Date spendingValidityEndDate;
    double pointsPerSpendingUnit;
    double spendingUnit;
    double entryPoints;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getLotteryDate() {
        return lotteryDate;
    }

    public void setLotteryDate(Date lotteryDate) {
        this.lotteryDate = lotteryDate;
    }

    public Date getSpendingValidityStartDate() {
        return spendingValidityStartDate;
    }

    public void setSpendingValidityStartDate(Date spendingValidityStartDate) {
        this.spendingValidityStartDate = spendingValidityStartDate;
    }

    public Date getSpendingValidityEndDate() {
        return spendingValidityEndDate;
    }

    public void setSpendingValidityEndDate(Date spendingValidityEndDate) {
        this.spendingValidityEndDate = spendingValidityEndDate;
    }

    public double getPointsPerSpendingUnit() {
        return pointsPerSpendingUnit;
    }

    public void setPointsPerSpendingUnit(double pointsPerSpendingUnit) {
        this.pointsPerSpendingUnit = pointsPerSpendingUnit;
    }

    public double getSpendingUnit() {
        return spendingUnit;
    }

    public void setSpendingUnit(double spendingUnit) {
        this.spendingUnit = spendingUnit;
    }

    public double getEntryPoints() {
        return entryPoints;
    }

    public void setEntryPoints(double entryPoints) {
        this.entryPoints = entryPoints;
    }
}
