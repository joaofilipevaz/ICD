<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" version="1.0" encoding="UTF-8"/>

    <xsl:param name="searchword">muda</xsl:param>

    <xsl:template match="/">
        <html>
            <body>
                <h2>Soneto</h2>
                <xsl:apply-templates select="//estrofe"/>
            </body>
        </html>

    </xsl:template>
    <xsl:template match="estrofe">
        <xsl:apply-templates select="./verso"/>
    </xsl:template>

    <xsl:template match="verso">
        <xsl:if test="contains(., $searchword)">
            <p>
                <xsl:value-of select="."/>
            </p>
        </xsl:if>
    </xsl:template>
</xsl:stylesheet>