<?xml version="1.0" encoding="utf-8" ?>
<!-- ========================================================================= -->
<!--                                                                           -->
<!-- VIP - Verify Installation Program                                         -->
<!--                                                                           -->
<!-- Copyright (C) 2013 www.verify-installation.org                            -->
<!--                                                                           -->
<!-- This file is part of the OpenSource Project VIP                           -->
<!--                                                                           -->
<!-- Documentation_________: http://verify-installation.org/howto/             -->
<!-- Contact_______________: info@verify-installation.org                      -->
<!--                                                                           -->
<!-- ========================================================================= -->
<xsl:stylesheet version="1.0" 
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
>
 
  <xsl:output method="html" 
              doctype-system="http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd"
              doctype-public="-//W3C//DTD XHTML 1.0 Strict//EN" 
              indent="yes" 
              encoding="UTF-8"
  />
    
  <xsl:template match="/">
    <html>
      <head>
      </head>
      <body>
        <xsl:call-template name="header" />
        <xsl:apply-templates select="*"/>
        <xsl:call-template name="footer" />
      </body>
    </html>
  </xsl:template>

  <xsl:template match="verify.installation.report">
    <xsl:apply-templates select="*"/>
  </xsl:template>

  <xsl:template match="application">
    <h1>
      <xsl:value-of select="@product" />
      <xsl:text>, Version </xsl:text>
      <xsl:value-of select="@version" />
      <xsl:text> - Installation Verification</xsl:text>
    </h1>
    <p id="application.comment">
      <xsl:value-of select="./comment"/>
    </p>
    <p id="id.date">
      Date: <xsl:value-of select="../date"/>
    </p>
    <xsl:call-template name="error.summary" />
    <xsl:apply-templates select="workdirectory"/>
  </xsl:template>
  
  <xsl:template match="workdirectory">
    <h2 id="workingdirectory.header">Work Directory</h2>
    <p id="workdirectory">
      <xsl:text>Work directory: </xsl:text>
      <xsl:value-of select="@dir" />
      <br />
      can read: <xsl:value-of select="attribute[@name='canRead']/@actual" />
      <br />
      can write: <xsl:value-of select="attribute[@name='canWrite']/@actual" />
    </p>
  </xsl:template>
  
  <xsl:template match="os">
    <h2 id="os.header">Operating System</h2>
    <p id="os.comment">
      <xsl:value-of select="comment" />
    </p>
    <p id="os.expected">
      Expected:
      <br />
      Bitsystem: <xsl:value-of select="expected/@bitSystem" />
      <br />
      Name: <xsl:value-of select="expected/@name" />
      <br />
      Allowed versions: <xsl:value-of select="expected/@versions" />
    </p>
    <p id="os.actual">
      Actual:
      <br />
      Bitsystem: <xsl:value-of select="actual/@bitSystem" />
      <br />
      Name: <xsl:value-of select="actual/@name" />
      <br />
    </p>
  </xsl:template>
  
  <xsl:template match="javaRuntime">
    <h2 id="javaRuntime.header">Java Runtime</h2>
    <p id="javaRuntime.comment">
      <xsl:value-of select="comment" />
    </p>
    <expected bitSystem="64" version="1.6+"/>
    <p id="javaRuntime.expected">
      Expected:
      <br />
      Bitsystem: <xsl:value-of select="expected/@bitSystem" />
      <br />
      Version: <xsl:value-of select="expected/@version" />
      <br />
    </p>
    <p id="javaRuntime.actual">
      Actual:
      <br />
      Vendor: <xsl:value-of select="actual/@vendor" />
      <br />
      Version: <xsl:value-of select="actual/@version" />
      <br />
      Bitsystem: <xsl:value-of select="actual/@bitSystem" />
      <br />
      Class Version: <xsl:value-of select="actual/@classVersion" />
      <br />
      Specification Version: <xsl:value-of select="actual/@specificationVersion" />
      <br />
    </p>
  </xsl:template>
  
  <xsl:template match="classpath">
    <h2 id="classpath.header">Classpath</h2>
    <ul id="classpath.classes">
      <xsl:for-each select="location">
        <li><xsl:value-of select="." /></li>
      </xsl:for-each>
    </ul>
  </xsl:template>
  
  <xsl:template match="classes.in.classpath">
    <h2 id="classes.in.classpath.header">Classes in the Classpath</h2>
    <table id="classes.in.classpath.table">
      <thead>
        <tr>
          <td><xsl:text>Description</xsl:text></td>
          <td><xsl:text>Class</xsl:text></td>
          <td><xsl:text>Loadable</xsl:text></td>
          <td><xsl:text>Loaded from</xsl:text></td>
          <td><xsl:text>Version</xsl:text></td>
        </tr>       
      </thead>
      <tbody>
        <xsl:for-each select="class">
          <tr>
            <td><xsl:value-of select="@comment" /></td>
            <td><xsl:value-of select="@name" /></td>
            <td><xsl:value-of select="@loadable" /></td>
            <td><xsl:value-of select="@loadedFrom" /></td>
            <td><xsl:value-of select="@version" /></td>
          </tr>       
        </xsl:for-each>
      </tbody>
    </table>
  </xsl:template>
  
  <xsl:template match="files.in.classpath">
    <h2 id="files.in.classpath.header">Files in the Classpath</h2>
    <table id="files.in.classpath.table">
      <thead>
        <tr>
          <td><xsl:text>File</xsl:text></td>
          <td><xsl:text>Exists</xsl:text></td>
          <td><xsl:text>Loaded from</xsl:text></td>
          <td><xsl:text>can read, expected/actual</xsl:text></td>
          <td><xsl:text>can write, expected/actual</xsl:text></td>
          <td><xsl:text>can execute, expected/actual</xsl:text></td>
        </tr>       
      </thead>
      <tbody>
        <xsl:for-each select="file">
          <tr>
            <td><xsl:value-of select="@name" /></td>
            <td><xsl:value-of select="@exists" /></td>
            <td><xsl:value-of select="@loadedFrom" /></td>
            <td>
              <xsl:value-of select="attribute[@name='canRead']/@expected" />
              /
              <xsl:value-of select="attribute[@name='canRead']/@actual" />
            </td>
            <td>
              <xsl:value-of select="attribute[@name='canWrite']/@expected" />
              /
              <xsl:value-of select="attribute[@name='canWrite']/@actual" />
            </td>
            <td>
              <xsl:value-of select="attribute[@name='canExecute']/@expected" />
              /
              <xsl:value-of select="attribute[@name='canExecute']/@actual" />
            </td>
          </tr>       
        </xsl:for-each>
      </tbody>
    </table>
  </xsl:template>
  
  <xsl:template match="folders">
    <h2 id="folders.header">Folders</h2>
    <table id="folders.table">
      <thead>
        <tr>
          <td><xsl:text>Folder</xsl:text></td>
          <td><xsl:text>Exists</xsl:text></td>
          <td><xsl:text>can read, expected/actual</xsl:text></td>
          <td><xsl:text>can write, expected/actual</xsl:text></td>
        </tr>       
      </thead>
      <tbody>
        <xsl:for-each select="folder">
          <!-- TODO use the comment -->
          <tr>
            <td><xsl:value-of select="@name" /></td>
            <td><xsl:value-of select="@exists" /></td>
            <td>
              <xsl:value-of select="attribute[@name='canRead']/@expected" />
              /
              <xsl:value-of select="attribute[@name='canRead']/@actual" />
            </td>
            <td>
              <xsl:value-of select="attribute[@name='canWrite']/@expected" />
              /
              <xsl:value-of select="attribute[@name='canWrite']/@actual" />
            </td>
          </tr>       
        </xsl:for-each>
      </tbody>
    </table>
  </xsl:template>
  
  <xsl:template match="files">
    <h2 id="files.header">Files</h2>
    <table id="files.table">
      <thead>
        <tr>
          <td><xsl:text>Folder</xsl:text></td>
          <td><xsl:text>Exists</xsl:text></td>
          <td><xsl:text>can read, expected/actual</xsl:text></td>
          <td><xsl:text>can write, expected/actual</xsl:text></td>
        </tr>       
      </thead>
      <tbody>
        <xsl:for-each select="file">
          <!-- TODO use the file comment -->
          <tr>
            <td><xsl:value-of select="@name" /></td>
            <td><xsl:value-of select="@exists" /></td>
            <td>
              <xsl:value-of select="attribute[@name='canRead']/@expected" />
              /
              <xsl:value-of select="attribute[@name='canRead']/@actual" />
            </td>
            <td>
              <xsl:value-of select="attribute[@name='canWrite']/@expected" />
              /
              <xsl:value-of select="attribute[@name='canWrite']/@actual" />
            </td>
          </tr>       
        </xsl:for-each>
      </tbody>
    </table>
  </xsl:template>
  
  <xsl:template match="urls">
    <h2 id="urls.header">URL's</h2>
    <table id="urls.table">
      <thead>
        <tr>
          <td><xsl:text>URL</xsl:text></td>
          <td><xsl:text>can read</xsl:text></td>
        </tr>       
      </thead>
      <tbody>
        <xsl:for-each select="url">
          <!-- TODO use the url comment -->
          <tr>
            <td><xsl:value-of select="@location" /></td>
            <td><xsl:value-of select="@canRead" /></td>
          </tr>       
        </xsl:for-each>
      </tbody>
    </table>
  </xsl:template>
  
  <xsl:template match="libraries">
    <h2 id="libraries.header">Libraries</h2>
    <table id="libraries.table">
      <thead>
        <tr>
          <td><xsl:text>Library</xsl:text></td>
          <td><xsl:text>can read</xsl:text></td>
        </tr>       
      </thead>
      <tbody>
        <xsl:for-each select="library">
          <!-- TODO use the library comment -->
          <tr>
            <td><xsl:value-of select="@name" /></td>
            <td><xsl:value-of select="@canRead" /></td>
          </tr>       
        </xsl:for-each>
      </tbody>
    </table>
  </xsl:template>
  
  <xsl:template match="executables">
    <h2 id="executables.header">Executables</h2>
    <table id="executables.table">
      <thead>
        <tr>
          <td><xsl:text>Library</xsl:text></td>
          <td><xsl:text>found</xsl:text></td>
          <td><xsl:text>Parent Folder</xsl:text></td>
          <td><xsl:text>Operating System (expected/actual)</xsl:text></td>
        </tr>       
      </thead>
      <tbody>
        <xsl:for-each select="executable">
          <!-- TODO use the executables comment -->
          <tr>
            <td><xsl:value-of select="@name" /></td>
            <td><xsl:value-of select="@found" /></td>
            <td><xsl:value-of select="parentDirectory" /></td>
            <td>
              <xsl:value-of select="os/@expected" />
              /
              <xsl:value-of select="os/@actual" />
            </td>
          </tr>
        </xsl:for-each>
      </tbody>
    </table>
  </xsl:template>
  
  <xsl:template match="systemProperties">
    <h2 id="systemProperties.header">System Properties</h2>
    <table id="systemProperties.table">
      <thead>
        <tr>
          <td><xsl:text>Property</xsl:text></td>
          <td><xsl:text>Key exists</xsl:text></td>
          <td><xsl:text>expected</xsl:text></td>
          <td><xsl:text>actual</xsl:text></td>
        </tr>       
      </thead>
      <tbody>
        <xsl:for-each select="property">
          <!-- TODO use the property comment -->
          <tr>
            <td><xsl:value-of select="@key" /></td>
            <td><xsl:value-of select="@exists" /></td>
            <td><xsl:value-of select="value/@expected" /></td>
            <td><xsl:value-of select="value/@actual" /></td>
          </tr>
        </xsl:for-each>
      </tbody>
    </table>
  </xsl:template>
  
  <xsl:template match="fileProperties">
    <h2 id="fileProperties.header">Properties in files</h2>
    <table id="fileProperties.table">
      <thead>
        <tr>
          <td><xsl:text>Filename</xsl:text></td>
          <td><xsl:text>File exists</xsl:text></td>
          <td><xsl:text>Key</xsl:text></td>
          <td><xsl:text>Key exists</xsl:text></td>
          <td><xsl:text>expected</xsl:text></td>
          <td><xsl:text>actual</xsl:text></td>
        </tr>       
      </thead>
      <tbody>
        <xsl:for-each select="property">
          <!-- TODO use the property comment -->
          <tr>
            <td><xsl:value-of select="@file" /></td>
            <td><xsl:value-of select="@fileExist" /></td>
            <td><xsl:value-of select="@key" /></td>
            <td><xsl:value-of select="@keyExist" /></td>
            <td><xsl:value-of select="value/@expected" /></td>
            <td><xsl:value-of select="value/@actual" /></td>
          </tr>
        </xsl:for-each>
      </tbody>
    </table>
  </xsl:template>
  
  <xsl:template name="error.summary">
    <xsl:choose>
      <xsl:when test="//errors/@count = '0'">
        <h2 id="error.summary">Summary: No Errors</h2>
      </xsl:when>
      <xsl:otherwise>
        <h2 id="error.summary">Summary: Errors found</h2>
        <ul>
          <xsl:for-each select="//error">
            <li><xsl:value-of select="." /></li>
          </xsl:for-each>
        </ul>
      </xsl:otherwise>
    </xsl:choose>
  </xsl:template>
  
  <xsl:template name="header">
    <!-- Placeholder for header. -->
  </xsl:template>
  
  <xsl:template name="footer">
    <hr id="footer.hr" />
    <div id="footer">
      Verifying with VIP-<xsl:value-of select="/*/@language" />
      , version <xsl:value-of select="/*/@vipVersion" /> 
    </div>
  </xsl:template>
  
  <xsl:template match="date">
    <!-- No output. -->
  </xsl:template>
  
  <xsl:template match="errors">
    <!-- No output. -->
  </xsl:template>
  
  <!-- To catch all not specially defined nodes: -->
  <xsl:template match="*">
    <xsl:value-of select="name(.)" />
  </xsl:template>
  
</xsl:stylesheet>