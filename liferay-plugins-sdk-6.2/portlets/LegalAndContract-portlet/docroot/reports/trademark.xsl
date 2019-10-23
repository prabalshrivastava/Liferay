<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:xs="http://www.w3.org/2001/XMLSchema" xmlns:fo="http://www.w3.org/1999/XSL/Format"
	exclude-result-prefixes="xs" version="2.0">

	<xsl:output method="xml" indent="yes" />
	<xsl:template match="/">
		<fo:root>
			<fo:layout-master-set>
				<fo:simple-page-master master-name="A4-landspace"
					page-height="21.0cm" page-width="29.7cm" margin-top="0.8cm"
					margin-bottom="1.5cm" margin-left="1cm" margin-right="1cm">
					<fo:region-body margin-top="2.0cm" margin-bottom="0.5cm" />
					<fo:region-before region-name="first-page-header"
						precedence="true"></fo:region-before>
					<fo:region-after region-name="first-page-footer"
						display-align="after"></fo:region-after>
				</fo:simple-page-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="A4-landspace">
				<fo:static-content flow-name="first-page-header">
					<fo:block>
						<fo:table>
							<fo:table-body>
								<fo:table-cell>
									<fo:block>
										<xsl:variable name="var"
											select="//extras//entry[key='Logo']/value"></xsl:variable>
										<fo:external-graphic src='{$var}' height="50%"
											content-width="50%" scaling="non-uniform" />
									</fo:block>
								</fo:table-cell>
								<fo:table-cell>
									<fo:block xsl:use-attribute-sets="header">
									</fo:block>
								</fo:table-cell>
								<fo:table-cell xsl:use-attribute-sets="header"
									display-align="after">
									<fo:block>
										<xsl:value-of select="//extras//entry[key='TimeStamp']/value" />
									</fo:block>
								</fo:table-cell>
							</fo:table-body>
						</fo:table>
					</fo:block>
				</fo:static-content>
				<fo:static-content flow-name="first-page-footer">
					<fo:block xsl:use-attribute-sets="header">
						Page
						<fo:page-number />
						of
						<fo:page-number-citation ref-id="theEnd" />
					</fo:block>
				</fo:static-content>
				<fo:flow flow-name="xsl-region-body">
					<fo:block>
						<xsl:apply-templates select="/tmList" />
					</fo:block>
					<fo:block id="theEnd" />
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
	<xsl:template match="/tmList">
		<fo:block>
			<fo:block font-size="7pt">
				<fo:table border="solid">
					<fo:table-header>
						<fo:table-row border="solid" border-after-width.length="1pt"
    border-after-width.conditionality="retain">
							<xsl:for-each select="*[2]/dataMap/entry/key">
								<xsl:if test="text() != 'DetailsLink'">
									<fo:table-cell xsl:use-attribute-sets="headerBorder">
										<fo:block font-weight="bold" >
											<xsl:value-of select="." />
										</fo:block>
									</fo:table-cell>
								</xsl:if>
							</xsl:for-each>
						</fo:table-row>
					</fo:table-header>
					<fo:table-body>
						<xsl:for-each select="*/dataMap">
							<xsl:choose>
								<xsl:when test="position() mod 2 != 0">
									<fo:table-row>
										<xsl:for-each select="*">
											<xsl:if test="key/text() != 'DetailsLink'">
												<fo:table-cell xsl:use-attribute-sets="oddBorder">
													<xsl:call-template name="cell"></xsl:call-template>
												</fo:table-cell>
											</xsl:if>
										</xsl:for-each>
									</fo:table-row>
								</xsl:when>
								<xsl:otherwise>
									<fo:table-row>
										<xsl:for-each select="*">
											<xsl:if test="key/text() != 'DetailsLink'">
												<fo:table-cell xsl:use-attribute-sets="evenBorder">
													<xsl:call-template name="cell"></xsl:call-template>
												</fo:table-cell>
											</xsl:if>
										</xsl:for-each>
									</fo:table-row>
								</xsl:otherwise>
							</xsl:choose>
						</xsl:for-each>
					</fo:table-body>
				</fo:table>
			</fo:block>
		</fo:block>
	</xsl:template>
	<xsl:attribute-set name="headerBorder">
		<xsl:attribute name="border">solid 0.1mm black</xsl:attribute>
		<xsl:attribute name="color">white</xsl:attribute>
		<xsl:attribute name="background-color">#4d5d63</xsl:attribute>
		<xsl:attribute name="padding-top">5pt</xsl:attribute>
		<xsl:attribute name="padding-bottom">5pt</xsl:attribute>
		<xsl:attribute name="padding-left">2pt</xsl:attribute>
		<xsl:attribute name="padding-right">2pt</xsl:attribute>
		<xsl:attribute name="text-align">center</xsl:attribute>
		<xsl:attribute name="display-align">after</xsl:attribute>
	</xsl:attribute-set>
	<xsl:attribute-set name="evenBorder">
		<xsl:attribute name="border">solid 0.1mm black</xsl:attribute>
		<xsl:attribute name="background-color">#F5F8FB</xsl:attribute>
		<xsl:attribute name="padding-top">5pt</xsl:attribute>
		<xsl:attribute name="padding-bottom">5pt</xsl:attribute>
		<xsl:attribute name="padding-left">2pt</xsl:attribute>
		<xsl:attribute name="padding-right">2pt</xsl:attribute>
		<xsl:attribute name="text-align">center</xsl:attribute>
		<xsl:attribute name="display-align">center</xsl:attribute>
	</xsl:attribute-set>
	<xsl:attribute-set name="oddBorder">
		<xsl:attribute name="border">solid 0.1mm black</xsl:attribute>
		<xsl:attribute name="background-color">white</xsl:attribute>
		<xsl:attribute name="padding-top">5pt</xsl:attribute>
		<xsl:attribute name="padding-bottom">5pt</xsl:attribute>
		<xsl:attribute name="padding-left">2pt</xsl:attribute>
		<xsl:attribute name="padding-right">2pt</xsl:attribute>
		<xsl:attribute name="text-align">center</xsl:attribute>
		<xsl:attribute name="display-align">center</xsl:attribute>
	</xsl:attribute-set>

	<xsl:attribute-set name="header">
		<xsl:attribute name="font-size">8pt</xsl:attribute>
		<xsl:attribute name="text-align">right</xsl:attribute>
	</xsl:attribute-set>
	<xsl:template name="cell">
		<fo:block linefeed-treatment="preserve" xsl:use-attribute-sets="fontFamily">
			<xsl:choose>
				<xsl:when test="key = 'Trademark'">
					<xsl:variable name="var" select="value"></xsl:variable>
					<!-- content-width="scale-down-to-fit" -->
					<xsl:choose>
						<xsl:when test="contains($var,'http')">
							<fo:external-graphic src='{$var}'
								content-height="scale-to-fit"  content-width="1.59cm"
								scaling="uniform" />
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="value" />
						</xsl:otherwise>
					</xsl:choose>
				</xsl:when>
				<xsl:when test="key = 'Application Number'">
					<xsl:variable name="link" select="..//entry[last()]//value"></xsl:variable>
					<fo:basic-link external-destination="url({$link})"
						color="blue">
						<xsl:choose>
							<xsl:when test="string-length(value) > 10">
								<xsl:call-template name="intersperse-with-zero-spaces">
									<xsl:with-param name="str" select="value" />
								</xsl:call-template>
							</xsl:when>
							<xsl:otherwise>
								<xsl:value-of select="value" />
							</xsl:otherwise>
						</xsl:choose>
					</fo:basic-link>
				</xsl:when>
				<xsl:when test="(key = 'Registration No') or (key = 'Registered Owner1') or (key = 'Logo Title/Trademark1 (Latin)')">
					<xsl:choose>
						<xsl:when test="string-length(value) > 10">
							<xsl:call-template name="intersperse-with-zero-spaces">
								<xsl:with-param name="str" select="value" />
							</xsl:call-template>
						</xsl:when>
						<xsl:otherwise>
							<xsl:value-of select="value" />
						</xsl:otherwise>
					</xsl:choose>
				</xsl:when>
				<xsl:when test="key = 'DetailsLink'">
				</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="value" />
				</xsl:otherwise>
			</xsl:choose>
		</fo:block>
	</xsl:template>
	
	<xsl:template name="intersperse-with-zero-spaces">
    <xsl:param name="str"/>
    <xsl:variable name="spacechars">
        &#x9;&#xA;
        &#x2000;&#x2001;&#x2002;&#x2003;&#x2004;&#x2005;
        &#x2006;&#x2007;&#x2008;&#x2009;&#x200A;&#x200B;
    </xsl:variable>

    <xsl:if test="string-length($str) &gt; 0">
        <xsl:variable name="c1" select="substring($str, 1, 1)"/>
        <xsl:variable name="c2" select="substring($str, 2, 1)"/>

        <xsl:value-of select="$c1"/>
        <xsl:if test="$c2 != '' and
            not(contains($spacechars, $c1) or
            contains($spacechars, $c2))">
            <xsl:text>&#x200B;</xsl:text>
        </xsl:if>

        <xsl:call-template name="intersperse-with-zero-spaces">
            <xsl:with-param name="str" select="substring($str, 2)"/>
        </xsl:call-template>
    </xsl:if>
</xsl:template>
<xsl:attribute-set name="fontFamily">
		<xsl:attribute name="font-family">NanumGothic,Abadi MT Condensed Extra Bold,Abadi MT Condensed Light,Al Bayan,Al Nile,Al Tarikh,American Typewriter,Andale Mono,Apple Braille,Apple Chancery,Apple Color Emoji,Apple SD Gothic Neo,Apple Symbols,AppleGothic,AppleMyungjo,Arial,Arial Black,Arial Hebrew,Arial Hebrew Scholar,Arial Narrow,Arial Rounded MT Bold,Arial Unicode MS,Athelas,Avenir,Avenir Next,Avenir Next Condensed,Ayuthaya,Baghdad,Bangla MN,Bangla Sangam MN,Baoli SC,Baskerville,Baskerville Old Face,Batang,Bauhaus 93,Beirut,Bell MT,Bernard MT Condensed,Big Caslon,Bodoni 72,Bodoni 72 Oldstyle,Bodoni 72 Smallcaps,Bodoni Ornaments,Book Antiqua,Bookman Old Style,Bookshelf Symbol 7,Bradley Hand,Braggadocio,Britannic Bold,Brush Script MT,Calibri,Calisto MT,Cambria,Cambria Math,Candara,Century,Century Gothic,Century Schoolbook,Chalkboard,Chalkboard SE,Chalkduster,Charter,Cochin,Colonna MT,Comic Sans MS,Consolas,Constantia,Cooper Black,Copperplate,Copperplate Gothic Bold,Copperplate Gothic Light,Corbel,Corsiva Hebrew,Courier,Courier New,CRU Chandra 56,Curlz MT,Damascus,DecoType Naskh,Desdemona,Devanagari MT,Devanagari Sangam MN,Dialog,DialogInput,Didot,DIN Alternate,DIN Condensed,Diwan Kufi,Diwan Thuluth,Edwardian Script ITC,Engravers MT,Euphemia UCAS,Eurostile,Farah,Farisi,Footlight MT Light,Franklin Gothic Book,Franklin Gothic Medium,Futura,Gabriola,Garamond,GB18030 Bitmap,Geeza Pro,Geneva,Georgia,Gill Sans,Gill Sans MT,Gloucester MT Extra Condensed,Goudy Old Style,Gujarati MT,Gujarati Sangam MN,Gulim,GungSeo,Gurmukhi MN,Gurmukhi MT,Gurmukhi Sangam MN,Haettenschweiler,Hannotate SC,Hannotate TC,HanziPen SC,HanziPen TC,Harrington,HeadLineA,Heiti SC,Heiti TC,Helvetica,Helvetica Neue,Herculanum,Hiragino Kaku Gothic Pro,Hiragino Kaku Gothic ProN,Hiragino Kaku Gothic Std,Hiragino Kaku Gothic StdN,Hiragino Maru Gothic Pro,Hiragino Maru Gothic ProN,Hiragino Mincho Pro,Hiragino Mincho ProN,Hiragino Sans GB,Hoefler Text,Impact,Imprint MT Shadow,InaiMathi,Iowan Old Style,ITF Devanagari,Kailasa,Kaiti SC,Kaiti TC,Kannada MN,Kannada Sangam MN,Kefa,Khmer MN,Khmer Sangam MN,Kino MT,Kohinoor Devanagari,Kokonor,Krungthep,KufiStandardGK,Lantinghei SC,Lantinghei TC,Lao MN,Lao Sangam MN,Libian SC,LiHei Pro,LiSong Pro,Lucida Blackletter,Lucida Bright,Lucida Calligraphy,Lucida Console,Lucida Fax,Lucida Grande,Lucida Handwriting,Lucida Sans,Lucida Sans Typewriter,Lucida Sans Unicode,Luminari,Malayalam MN,Malayalam Sangam MN,Marion,Marker Felt,Marlett,Matura MT Script Capitals,Meiryo,Menlo,Microsoft Himalaya,Microsoft Sans Serif,Microsoft Tai Le,Microsoft Yi Baiti,MingLiU,MingLiU-ExtB,MingLiU_HKSCS,MingLiU_HKSCS-ExtB,Mishafi,Mishafi Gold,Mistral,Modern No. 20,Monaco,Mongolian Baiti,Monospaced,Monotype Corsiva,Monotype Sorts,MS Gothic,MS Mincho,MS PGothic,MS PMincho,MS Reference Sans Serif,MS Reference Specialty,Mshtakan,MT Extra,Muna,Myanmar MN,Myanmar Sangam MN,Nadeem,Nanum Brush Script,Nanum Gothic,Nanum Myeongjo,Nanum Pen Script,New Peninim MT,News Gothic MT,Noteworthy,Onyx,Optima,Oriya MN,Oriya Sangam MN,Osaka,Palatino,Palatino Linotype,Papyrus,PCMyungjo,Perpetua,Perpetua Titling MT,Phosphate,PilGi,Plantagenet Cherokee,Playbill,PMingLiU,PMingLiU-ExtB,PT Mono,PT Sans,PT Sans Caption,PT Sans Narrow,PT Serif,PT Serif Caption,Raanana,Rockwell,Rockwell Extra Bold,Sana,SansSerif,Sathu,Savoye LET,Seravek,Serif,Shree Devanagari 714,SignPainter,Silom,SimHei,SimSun,SimSun-ExtB,Sinhala MN,Sinhala Sangam MN,Skia,Snell Roundhand,Songti SC,Songti TC,Stencil,STFangsong,STHeiti,STIXGeneral,STIXIntegralsD,STIXIntegralsSm,STIXIntegralsUp,STIXIntegralsUpD,STIXIntegralsUpSm,STIXNonUnicode,STIXSizeFiveSym,STIXSizeFourSym,STIXSizeOneSym,STIXSizeThreeSym,STIXSizeTwoSym,STIXVariants,STKaiti,STSong,Sukhumvit Set,Superclarendon,Symbol,Tahoma,Tamil MN,Tamil Sangam MN,Telugu MN,Telugu Sangam MN,Thonburi,Times,Times New Roman,Trattatello,Trebuchet MS,Tw Cen MT,Verdana,Waseem,Wawati SC,Wawati TC,Webdings,Weibei SC,Weibei TC,Wide Latin,Wingdings,Wingdings 2,Wingdings 3,Xingkai SC,Yuanti SC,YuGothic,YuMincho,Yuppy SC,Yuppy TC,Zapf Dingbats,Zapfino</xsl:attribute>
		</xsl:attribute-set>
</xsl:stylesheet>