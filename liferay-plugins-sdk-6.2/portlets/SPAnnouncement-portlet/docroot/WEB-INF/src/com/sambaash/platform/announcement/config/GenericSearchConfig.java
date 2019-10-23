package com.sambaash.platform.announcement.config;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.util.Validator;

public class GenericSearchConfig {

	private Boolean hideFitlers;
	private Boolean dateFitlers;
	private String dateFitlersField;
	private String freeTextSearch;
	public String getFreeTextSearch() {
		return freeTextSearch;
	}

	public void setFreeTextSearch(String freeTextSearch) {
		this.freeTextSearch = freeTextSearch;
	}

	public String getDateFitlersField() {
		return dateFitlersField;
	}

	public void setDateFitlersField(String dateFitlersField) {
		this.dateFitlersField = dateFitlersField;
	}

	private Boolean sortFitlers;
	public Boolean getSortFitlers() {
		return sortFitlers;
	}

	public void setSortFitlers(Boolean sortFitlers) {
		this.sortFitlers = sortFitlers;
	}

	public Boolean getDateFitlers() {
		return dateFitlers;
	}

	public void setDateFitlers(Boolean dateFitlers) {
		this.dateFitlers = dateFitlers;
	}

	private Boolean hideExports;
	private Boolean disableUnwantedFilters;
	private Boolean disableTextSearch;
	private Boolean leftFilterPlacement;
	private String filterTopLabel;
	private List<GenericSearchFilter> filters;
	private String favouritesRoles;

	public String getFavouritesRoles() {
		return favouritesRoles;
	}

	public void setFavouritesRoles(String favouritesRoles) {
		this.favouritesRoles = favouritesRoles;
	}

	private Integer itemsPerPage;
	private String resultsOrientation;
	private Boolean enabledComponentFilters;
	private Boolean clearFiltersOnTextSearch;
	private Boolean adminOnlyExports;
	private Boolean hideFavourites;

	public Boolean getHideFavourites() {
		return hideFavourites;
	}

	public void setHideFavourites(Boolean hideFavourites) {
		this.hideFavourites = hideFavourites;
	}

	public Boolean getClearFiltersOnTextSearch() {
		return clearFiltersOnTextSearch;
	}

	public void setClearFiltersOnTextSearch(Boolean clearFiltersOnTextSearch) {
		this.clearFiltersOnTextSearch = clearFiltersOnTextSearch;
	}

	public List<GenericSearchFilter> getFilters() {
		return filters;
	}

	public void setFilters(List<GenericSearchFilter> filters) {
		this.filters = filters;
	}

	public void addFilter(GenericSearchFilter filter) {
		if (Validator.isNull(this.filters)) {
			this.filters = new ArrayList<GenericSearchFilter>();
		}
		this.filters.add(filter);
	}

	public Boolean getHideFitlers() {
		return hideFitlers;
	}

	public void setHideFitlers(Boolean hideFitlers) {
		this.hideFitlers = hideFitlers;
	}

	public Boolean getHideExports() {
		return hideExports;
	}

	public void setHideExports(Boolean hideExports) {
		this.hideExports = hideExports;
	}

	public Boolean getDisableUnwantedFilters() {
		return disableUnwantedFilters;
	}

	public void setDisableUnwantedFilters(Boolean disableUnwantedFilters) {
		this.disableUnwantedFilters = disableUnwantedFilters;
	}

	public Boolean getDisableTextSearch() {
		return disableTextSearch;
	}

	public void setDisableTextSearch(Boolean disableTextSearch) {
		this.disableTextSearch = disableTextSearch;
	}

	public Boolean getLeftFilterPlacement() {
		return leftFilterPlacement;
	}

	public void setLeftFilterPlacement(Boolean leftFilterPlacement) {
		this.leftFilterPlacement = leftFilterPlacement;
	}

	public String getFilterTopLabel() {
		return filterTopLabel;
	}

	public void setFilterTopLabel(String filterTopLabel) {
		this.filterTopLabel = filterTopLabel;
	}

	public Integer getItemsPerPage() {
		return itemsPerPage;
	}

	public void setItemsPerPage(Integer itemsPerPage) {
		this.itemsPerPage = itemsPerPage;
	}

	public String getResultsOrientation() {
		return resultsOrientation;
	}

	public void setResultsOrientation(String resultsOrientation) {
		this.resultsOrientation = resultsOrientation;
	}

	public Boolean getEnabledComponentFilters() {
		return enabledComponentFilters;
	}

	public void setEnabledComponentFilters(Boolean enabledComponentFilters) {
		this.enabledComponentFilters = enabledComponentFilters;
	}

	public Boolean getAdminOnlyExports() {
		return adminOnlyExports;
	}
	
	public void setAdminOnlyExports(Boolean adminOnlyExports) {
		this.adminOnlyExports = adminOnlyExports;
	}

	@Override
	public String toString() {
		return "GenericSearchConfig [hideFitlers=" + hideFitlers
				+ ", favouritesRoles=" + favouritesRoles
				+ ", dateFitlers=" + dateFitlers
				+ ", dateFitlersField=" + dateFitlersField
				+ ", freeTextSearch=" + freeTextSearch
				+ ", sortFitlers=" + sortFitlers
				+ ", hideFavourites=" + hideFavourites
				+ ", disableUnwantedFilters=" + disableUnwantedFilters
				+ ", disableTextSearch=" + disableTextSearch
				+ ", leftFilterPlacement=" + leftFilterPlacement
				+ ", filterTopLabel=" + filterTopLabel + ", filters=" + filters
				+ ", itemsPerPage=" + itemsPerPage + ", resultsOrientation="
				+ resultsOrientation + ", enabledComponentFilters="
				+ enabledComponentFilters + "]";
	}

}