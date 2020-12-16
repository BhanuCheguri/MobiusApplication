package com.poc.mobiusapplication;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BonusCouponModel {
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("valid_from")
    @Expose
    private String validFrom;
    @SerializedName("valid_until")
    @Expose
    private String validUntil;
    @SerializedName("is_active")
    @Expose
    private Boolean isActive;
    @SerializedName("is_deleted")
    @Expose
    private Object isDeleted;
    @SerializedName("tags")
    @Expose
    private Tags tags;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("last_updated_at")
    @Expose
    private String lastUpdatedAt;
    @SerializedName("code")
    @Expose
    private String code;
    @SerializedName("bonus_image_front")
    @Expose
    private String bonusImageFront;
    @SerializedName("bonus_image_back")
    @Expose
    private String bonusImageBack;
    @SerializedName("user_redeem_limit")
    @Expose
    private Integer userRedeemLimit;
    @SerializedName("user_limit")
    @Expose
    private Integer userLimit;
    @SerializedName("tab_type")
    @Expose
    private String tabType;
    @SerializedName("ribbon_msg")
    @Expose
    private String ribbonMsg;
    @SerializedName("is_bonus_booster_enabled")
    @Expose
    private Boolean isBonusBoosterEnabled;
    @SerializedName("wager_bonus_expiry")
    @Expose
    private Integer wagerBonusExpiry;
    @SerializedName("wager_to_release_ratio_numerator")
    @Expose
    private Integer wagerToReleaseRatioNumerator;
    @SerializedName("wager_to_release_ratio_denominator")
    @Expose
    private Integer wagerToReleaseRatioDenominator;
    @SerializedName("slabs")
    @Expose
    private List<Slab> slabs = null;
    @SerializedName("user_segmentation_type")
    @Expose
    private String userSegmentationType;
    @SerializedName("eligibility_user_levels")
    @Expose
    private List<Integer> eligibilityUserLevels = null;
    @SerializedName("eligibility_user_segments")
    @Expose
    private List<String> eligibilityUserSegments = null;
    @SerializedName("visibility_user_levels")
    @Expose
    private List<Integer> visibilityUserLevels = null;
    @SerializedName("visibility_user_segments")
    @Expose
    private List<String> visibilityUserSegments = null;
    @SerializedName("days_since_last_purchase_min")
    @Expose
    private Integer daysSinceLastPurchaseMin;
    @SerializedName("_cls")
    @Expose
    private String cls;
    @SerializedName("campaign")
    @Expose
    private String campaign;
    @SerializedName("bonus_booster")
    @Expose
    private String bonusBooster;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(String validFrom) {
        this.validFrom = validFrom;
    }

    public String getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(String validUntil) {
        this.validUntil = validUntil;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public Object getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Object isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) {
        this.tags = tags;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(String lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBonusImageFront() {
        return bonusImageFront;
    }

    public void setBonusImageFront(String bonusImageFront) {
        this.bonusImageFront = bonusImageFront;
    }

    public String getBonusImageBack() {
        return bonusImageBack;
    }

    public void setBonusImageBack(String bonusImageBack) {
        this.bonusImageBack = bonusImageBack;
    }

    public Integer getUserRedeemLimit() {
        return userRedeemLimit;
    }

    public void setUserRedeemLimit(Integer userRedeemLimit) {
        this.userRedeemLimit = userRedeemLimit;
    }

    public Integer getUserLimit() {
        return userLimit;
    }

    public void setUserLimit(Integer userLimit) {
        this.userLimit = userLimit;
    }

    public String getTabType() {
        return tabType;
    }

    public void setTabType(String tabType) {
        this.tabType = tabType;
    }

    public String getRibbonMsg() {
        return ribbonMsg;
    }

    public void setRibbonMsg(String ribbonMsg) {
        this.ribbonMsg = ribbonMsg;
    }

    public Boolean getIsBonusBoosterEnabled() {
        return isBonusBoosterEnabled;
    }

    public void setIsBonusBoosterEnabled(Boolean isBonusBoosterEnabled) {
        this.isBonusBoosterEnabled = isBonusBoosterEnabled;
    }

    public Integer getWagerBonusExpiry() {
        return wagerBonusExpiry;
    }

    public void setWagerBonusExpiry(Integer wagerBonusExpiry) {
        this.wagerBonusExpiry = wagerBonusExpiry;
    }

    public Integer getWagerToReleaseRatioNumerator() {
        return wagerToReleaseRatioNumerator;
    }

    public void setWagerToReleaseRatioNumerator(Integer wagerToReleaseRatioNumerator) {
        this.wagerToReleaseRatioNumerator = wagerToReleaseRatioNumerator;
    }

    public Integer getWagerToReleaseRatioDenominator() {
        return wagerToReleaseRatioDenominator;
    }

    public void setWagerToReleaseRatioDenominator(Integer wagerToReleaseRatioDenominator) {
        this.wagerToReleaseRatioDenominator = wagerToReleaseRatioDenominator;
    }

    public List<Slab> getSlabs() {
        return slabs;
    }

    public void setSlabs(List<Slab> slabs) {
        this.slabs = slabs;
    }

    public String getUserSegmentationType() {
        return userSegmentationType;
    }

    public void setUserSegmentationType(String userSegmentationType) {
        this.userSegmentationType = userSegmentationType;
    }

    public List<Integer> getEligibilityUserLevels() {
        return eligibilityUserLevels;
    }

    public void setEligibilityUserLevels(List<Integer> eligibilityUserLevels) {
        this.eligibilityUserLevels = eligibilityUserLevels;
    }

    public List<String> getEligibilityUserSegments() {
        return eligibilityUserSegments;
    }

    public void setEligibilityUserSegments(List<String> eligibilityUserSegments) {
        this.eligibilityUserSegments = eligibilityUserSegments;
    }

    public List<Integer> getVisibilityUserLevels() {
        return visibilityUserLevels;
    }

    public void setVisibilityUserLevels(List<Integer> visibilityUserLevels) {
        this.visibilityUserLevels = visibilityUserLevels;
    }

    public List<String> getVisibilityUserSegments() {
        return visibilityUserSegments;
    }

    public void setVisibilityUserSegments(List<String> visibilityUserSegments) {
        this.visibilityUserSegments = visibilityUserSegments;
    }

    public Integer getDaysSinceLastPurchaseMin() {
        return daysSinceLastPurchaseMin;
    }

    public void setDaysSinceLastPurchaseMin(Integer daysSinceLastPurchaseMin) {
        this.daysSinceLastPurchaseMin = daysSinceLastPurchaseMin;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public String getCampaign() {
        return campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }

    public String getBonusBooster() {
        return bonusBooster;
    }

    public void setBonusBooster(String bonusBooster) {
        this.bonusBooster = bonusBooster;
    }

    public class Slab {

        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("num")
        @Expose
        private Integer num;
        @SerializedName("min")
        @Expose
        private Double min;
        @SerializedName("max")
        @Expose
        private Double max;
        @SerializedName("wagered_percent")
        @Expose
        private Double wageredPercent;
        @SerializedName("wagered_max")
        @Expose
        private Double wageredMax;
        @SerializedName("otc_percent")
        @Expose
        private Double otcPercent;
        @SerializedName("otc_max")
        @Expose
        private Double otcMax;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getNum() {
            return num;
        }

        public void setNum(Integer num) {
            this.num = num;
        }

        public Double getMin() {
            return min;
        }

        public void setMin(Double min) {
            this.min = min;
        }

        public Double getMax() {
            return max;
        }

        public void setMax(Double max) {
            this.max = max;
        }

        public Double getWageredPercent() {
            return wageredPercent;
        }

        public void setWageredPercent(Double wageredPercent) {
            this.wageredPercent = wageredPercent;
        }

        public Double getWageredMax() {
            return wageredMax;
        }

        public void setWageredMax(Double wageredMax) {
            this.wageredMax = wageredMax;
        }

        public Double getOtcPercent() {
            return otcPercent;
        }

        public void setOtcPercent(Double otcPercent) {
            this.otcPercent = otcPercent;
        }

        public Double getOtcMax() {
            return otcMax;
        }

        public void setOtcMax(Double otcMax) {
            this.otcMax = otcMax;
        }
    }

    public class Tags {
    }
}
