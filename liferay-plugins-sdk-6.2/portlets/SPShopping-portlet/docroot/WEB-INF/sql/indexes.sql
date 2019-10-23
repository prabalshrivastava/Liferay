create index IX_8FB2E1FE on SPCartPackage (cartId);
create index IX_98826822 on SPCartPackage (packageId);

create index IX_56AE97F2 on SPCartPackageItem (spCartPackageId);

create index IX_2E861085 on SPDiscount (active_);
create index IX_1A3921ED on SPDiscount (packageId);

create index IX_60E4AA9F on SPPackageItems (itemId);
create index IX_88B71734 on SPPackageItems (packageId);

create index IX_2D06965D on SPSellingItem (active_);
create index IX_771C5D01 on SPSellingItem (entityClassNameId, entityClassPk);

create index IX_21CDCD90 on SPSellingPackage (active_);

create index IX_AC6DD95 on SPSellingPrice (priceRefId);

create index IX_4CFF7566 on SPTax (currencyCode);