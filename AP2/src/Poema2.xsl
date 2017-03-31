<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" version="1.0" encoding="UTF-8"/>

    <xsl:template match="/">
        <html>
            <body>
                <h2>Soneto</h2>
                <xsl:apply-templates select="//estrofe"/>
            </body>
        </html>

    </xsl:template>
    <xsl:template match="estrofe">
        <xsl:value-of select="position()"/>
        <xsl:if test="count(./verso) = 4">
            <xsl:text> - Quadra </xsl:text>
        </xsl:if>
        <xsl:if test="count(./verso) = 3">
            <xsl:text> - Terceto </xsl:text>
        </xsl:if>
        <xsl:apply-templates select="./verso"/>
        <br />
    </xsl:template>

    <xsl:template match="verso">
        <p>
            <xsl:value-of select="position()"/>
            <xsl:text> - </xsl:text>
            <xsl:value-of select="."/>
        </p>
    </xsl:template>
</xsl:stylesheet>