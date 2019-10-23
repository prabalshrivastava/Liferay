<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fo="http://www.w3.org/1999/XSL/Format"
	exclude-result-prefixes="xs" version="2.0">

	<xsl:output method="xml" indent="yes" />
	<xsl:template match="/">
		<fo:root>
			<fo:layout-master-set>
				<fo:simple-page-master master-name="A4-landspace"
					page-height="29.7cm" page-width="21.0cm" margin-top="0.5cm"
					margin-bottom="0.5cm" margin-left="1cm" margin-right="1cm">
					<fo:region-body margin-top="1.8cm" margin-bottom="3cm" />
					<fo:region-before region-name="first-page-header"
						extent="4cm" precedence="true"></fo:region-before>
					<fo:region-after region-name="first-page-footer"
						extent=".1cm" display-align="after"></fo:region-after>
				</fo:simple-page-master>
			</fo:layout-master-set>
			<xsl:variable name="profileLink" select="/profile/profileUrl"></xsl:variable>
			<fo:page-sequence master-reference="A4-landspace">
				<fo:static-content flow-name="first-page-header">
					<fo:block linefeed-treatment="preserve">
						<fo:table>
							<fo:table-body>
								<fo:table-cell>
									<fo:block>
										<xsl:variable name="var"
											select="//profile/authorLogoUrl"></xsl:variable>
										<fo:external-graphic src='{$var}' content-height="scale-to-fit"  content-width="1.59cm"
										scaling="uniform"  />
									</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block xsl:use-attribute-sets="header">
									</fo:block>
								</fo:table-cell>
								<fo:table-cell xsl:use-attribute-sets="header">
									<fo:block>
										<xsl:value-of select="//profile/timestamp" />
									</fo:block>
								</fo:table-cell>
							</fo:table-body>
						</fo:table>
					</fo:block>
				</fo:static-content>
				<fo:static-content flow-name="first-page-footer">
					<fo:block>
					</fo:block>
				</fo:static-content>
				<fo:flow flow-name="xsl-region-body">
					<fo:block xsl:use-attribute-sets="heading">
						<fo:block>
							<xsl:variable name="var"
										select="//profile/logoUrl"></xsl:variable>
							<fo:external-graphic src='{$var}' content-height="scale-to-fit"  content-width="1.59cm"
								scaling="uniform" />
						</fo:block>
							<fo:basic-link external-destination="url({$profileLink})" color="#005EB8">
								<xsl:value-of select="//profile/name" />
							</fo:basic-link>
					</fo:block>
					<xsl:if test="/profile/application">
						<fo:block xsl:use-attribute-sets="sectionHeading">
							<xsl:variable name="link" select="/profile/applicantUrl"></xsl:variable>
							<fo:basic-link external-destination="url({$link})" color="#005EB8">
								Application Details
							</fo:basic-link>
								<xsl:apply-templates select="/profile/application/data/entry[1]/key" />
								<xsl:apply-templates select="/profile/application/data/entry[2]/key" />
								<xsl:apply-templates select="/profile/application/data/entry[3]/key" />
							<fo:block margin-top="10pt" margin-bottom="10pt" xsl:use-attribute-sets="sectionHeading">
							<xsl:variable name="link" select="/profileUrl"></xsl:variable>
								<fo:basic-link external-destination="url({$profileLink})" color="#005EB8">
									Startup Details
								</fo:basic-link>	
							</fo:block>	
						</fo:block>
					</xsl:if>
					<fo:block padding-bottom="15pt" xsl:use-attribute-sets="paragraph">
						<xsl:value-of select="//profile/description" />
					</fo:block>
					<fo:block>
						<xsl:apply-templates select="//profile/data" />
					</fo:block>
					<fo:block>
						<xsl:apply-templates select="//profile/sections" />
					</fo:block>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
	<xsl:template match="/profile/application/data/entry/key">
	<fo:block xsl:use-attribute-sets="paragraph">
		<fo:block font-weight="bold" margin-bottom="5pt">
			<xsl:value-of select="."></xsl:value-of>
		</fo:block>
		<fo:block>
			<xsl:value-of select="../value"></xsl:value-of>
		</fo:block>
	</fo:block>
	</xsl:template>
	<xsl:template match="//profile/sections">
		<fo:block margin-top="15pt" xsl:use-attribute-sets="sectionHeading" padding-bottom="4pt">
			<xsl:value-of select="./name" />
		</fo:block>
						<xsl:apply-templates select="./section/data"></xsl:apply-templates>
	</xsl:template>
	<xsl:template match="data">
		<fo:block font-size="12pt">
			<fo:table>
				 <fo:table-column column-width="35%"/>
			     <fo:table-column column-width="65%"/>
     
				<fo:table-body>
					<xsl:for-each select="./entry">
							<xsl:choose>
								<xsl:when test="position() mod 2 != 0">
									<fo:table-row>
										<fo:table-cell xsl:use-attribute-sets="evenBorder">
											<fo:block xsl:use-attribute-sets="fontFamily">
												<xsl:value-of select="key" />
											</fo:block>
										</fo:table-cell>
										<fo:table-cell xsl:use-attribute-sets="evenBorder">
											<fo:block linefeed-treatment="preserve" xsl:use-attribute-sets="fontFamily">
												<xsl:value-of select="value" />
											</fo:block>
										</fo:table-cell>
									</fo:table-row>
								</xsl:when>
								<xsl:otherwise>
									<fo:table-row>
										<fo:table-cell xsl:use-attribute-sets="oddBorder">
											<fo:block xsl:use-attribute-sets="fontFamily">
												<xsl:value-of select="key" />
											</fo:block>
										</fo:table-cell>
										<fo:table-cell xsl:use-attribute-sets="oddBorder">
											<fo:block linefeed-treatment="preserve" xsl:use-attribute-sets="fontFamily">
												<xsl:value-of select="value" />
											</fo:block>
										</fo:table-cell>
									</fo:table-row>
								</xsl:otherwise>
							</xsl:choose>
					</xsl:for-each>
				</fo:table-body>
			</fo:table>
		</fo:block>
	</xsl:template>

	<xsl:attribute-set name="paragraph">
		<xsl:attribute name="font-size">10pt</xsl:attribute>
		<xsl:attribute name="margin-top">10pt</xsl:attribute>
		<xsl:attribute name="font-weight">normal</xsl:attribute>
	</xsl:attribute-set>
	<xsl:attribute-set name="gap">
		<xsl:attribute name="margin-top">15pt</xsl:attribute>
		<xsl:attribute name="margin-left">40pt</xsl:attribute>
	</xsl:attribute-set>

	<xsl:attribute-set name="heading">
		<xsl:attribute name="font-size">14pt</xsl:attribute>
		<xsl:attribute name="font-weight">bold</xsl:attribute>
		<xsl:attribute name="text-align">center</xsl:attribute>
		<xsl:attribute name="padding-bottom">0.5cm</xsl:attribute>
	</xsl:attribute-set>
	<xsl:attribute-set name="sectionHeading">
		<xsl:attribute name="font-size">11pt</xsl:attribute>
		<xsl:attribute name="font-weight">bold</xsl:attribute>
		<xsl:attribute name="text-align">left</xsl:attribute>
	</xsl:attribute-set>

	<xsl:attribute-set name="header">
		<xsl:attribute name="font-size">8pt</xsl:attribute>
		<xsl:attribute name="text-align">right</xsl:attribute>
	</xsl:attribute-set>

	<xsl:attribute-set name="oddBorder">
		<xsl:attribute name="padding-left">40pt</xsl:attribute>
		<xsl:attribute name="padding-top">3pt</xsl:attribute>
		<xsl:attribute name="background-color">#D3E8F1</xsl:attribute>
		<xsl:attribute name="height">16pt</xsl:attribute>
	</xsl:attribute-set>

	<xsl:attribute-set name="evenBorder">
		<xsl:attribute name="padding-top">3pt</xsl:attribute>
		<xsl:attribute name="padding-left">40pt</xsl:attribute>
		<xsl:attribute name="border">none</xsl:attribute>
		<xsl:attribute name="background-color">white</xsl:attribute>
		<xsl:attribute name="height">16pt</xsl:attribute>
	</xsl:attribute-set>

		<xsl:attribute-set name="fontFamily">
		<xsl:attribute name="font-family">NanumGothic,Abadi MT Condensed Extra Bold,Abadi MT Condensed Light,Al Bayan,Al Nile,Al Tarikh,American Typewriter,Andale Mono,Apple Braille,Apple Chancery,Apple Color Emoji,Apple SD Gothic Neo,Apple Symbols,AppleGothic,AppleMyungjo,Arial,Arial Black,Arial Hebrew,Arial Hebrew Scholar,Arial Narrow,Arial Rounded MT Bold,Arial Unicode MS,Athelas,Avenir,Avenir Next,Avenir Next Condensed,Ayuthaya,Baghdad,Bangla MN,Bangla Sangam MN,Baoli SC,Baskerville,Baskerville Old Face,Batang,Bauhaus 93,Beirut,Bell MT,Bernard MT Condensed,Big Caslon,Bodoni 72,Bodoni 72 Oldstyle,Bodoni 72 Smallcaps,Bodoni Ornaments,Book Antiqua,Bookman Old Style,Bookshelf Symbol 7,Bradley Hand,Braggadocio,Britannic Bold,Brush Script MT,Calibri,Calisto MT,Cambria,Cambria Math,Candara,Century,Century Gothic,Century Schoolbook,Chalkboard,Chalkboard SE,Chalkduster,Charter,Cochin,Colonna MT,Comic Sans MS,Consolas,Constantia,Cooper Black,Copperplate,Copperplate Gothic Bold,Copperplate Gothic Light,Corbel,Corsiva Hebrew,Courier,Courier New,CRU Chandra 56,Curlz MT,Damascus,DecoType Naskh,Desdemona,Devanagari MT,Devanagari Sangam MN,Dialog,DialogInput,Didot,DIN Alternate,DIN Condensed,Diwan Kufi,Diwan Thuluth,Edwardian Script ITC,Engravers MT,Euphemia UCAS,Eurostile,Farah,Farisi,Footlight MT Light,Franklin Gothic Book,Franklin Gothic Medium,Futura,Gabriola,Garamond,GB18030 Bitmap,Geeza Pro,Geneva,Georgia,Gill Sans,Gill Sans MT,Gloucester MT Extra Condensed,Goudy Old Style,Gujarati MT,Gujarati Sangam MN,Gulim,GungSeo,Gurmukhi MN,Gurmukhi MT,Gurmukhi Sangam MN,Haettenschweiler,Hannotate SC,Hannotate TC,HanziPen SC,HanziPen TC,Harrington,HeadLineA,Heiti SC,Heiti TC,Helvetica,Helvetica Neue,Herculanum,Hiragino Kaku Gothic Pro,Hiragino Kaku Gothic ProN,Hiragino Kaku Gothic Std,Hiragino Kaku Gothic StdN,Hiragino Maru Gothic Pro,Hiragino Maru Gothic ProN,Hiragino Mincho Pro,Hiragino Mincho ProN,Hiragino Sans GB,Hoefler Text,Impact,Imprint MT Shadow,InaiMathi,Iowan Old Style,ITF Devanagari,Kailasa,Kaiti SC,Kaiti TC,Kannada MN,Kannada Sangam MN,Kefa,Khmer MN,Khmer Sangam MN,Kino MT,Kohinoor Devanagari,Kokonor,Krungthep,KufiStandardGK,Lantinghei SC,Lantinghei TC,Lao MN,Lao Sangam MN,Libian SC,LiHei Pro,LiSong Pro,Lucida Blackletter,Lucida Bright,Lucida Calligraphy,Lucida Console,Lucida Fax,Lucida Grande,Lucida Handwriting,Lucida Sans,Lucida Sans Typewriter,Lucida Sans Unicode,Luminari,Malayalam MN,Malayalam Sangam MN,Marion,Marker Felt,Marlett,Matura MT Script Capitals,Meiryo,Menlo,Microsoft Himalaya,Microsoft Sans Serif,Microsoft Tai Le,Microsoft Yi Baiti,MingLiU,MingLiU-ExtB,MingLiU_HKSCS,MingLiU_HKSCS-ExtB,Mishafi,Mishafi Gold,Mistral,Modern No. 20,Monaco,Mongolian Baiti,Monospaced,Monotype Corsiva,Monotype Sorts,MS Gothic,MS Mincho,MS PGothic,MS PMincho,MS Reference Sans Serif,MS Reference Specialty,Mshtakan,MT Extra,Muna,Myanmar MN,Myanmar Sangam MN,Nadeem,Nanum Brush Script,Nanum Gothic,Nanum Myeongjo,Nanum Pen Script,New Peninim MT,News Gothic MT,Noteworthy,Onyx,Optima,Oriya MN,Oriya Sangam MN,Osaka,Palatino,Palatino Linotype,Papyrus,PCMyungjo,Perpetua,Perpetua Titling MT,Phosphate,PilGi,Plantagenet Cherokee,Playbill,PMingLiU,PMingLiU-ExtB,PT Mono,PT Sans,PT Sans Caption,PT Sans Narrow,PT Serif,PT Serif Caption,Raanana,Rockwell,Rockwell Extra Bold,Sana,SansSerif,Sathu,Savoye LET,Seravek,Serif,Shree Devanagari 714,SignPainter,Silom,SimHei,SimSun,SimSun-ExtB,Sinhala MN,Sinhala Sangam MN,Skia,Snell Roundhand,Songti SC,Songti TC,Stencil,STFangsong,STHeiti,STIXGeneral,STIXIntegralsD,STIXIntegralsSm,STIXIntegralsUp,STIXIntegralsUpD,STIXIntegralsUpSm,STIXNonUnicode,STIXSizeFiveSym,STIXSizeFourSym,STIXSizeOneSym,STIXSizeThreeSym,STIXSizeTwoSym,STIXVariants,STKaiti,STSong,Sukhumvit Set,Superclarendon,Symbol,Tahoma,Tamil MN,Tamil Sangam MN,Telugu MN,Telugu Sangam MN,Thonburi,Times,Times New Roman,Trattatello,Trebuchet MS,Tw Cen MT,Verdana,Waseem,Wawati SC,Wawati TC,Webdings,Weibei SC,Weibei TC,Wide Latin,Wingdings,Wingdings 2,Wingdings 3,Xingkai SC,Yuanti SC,YuGothic,YuMincho,Yuppy SC,Yuppy TC,Zapf Dingbats,Zapfino</xsl:attribute>
		</xsl:attribute-set>
</xsl:stylesheet>