# 🚀 DataPorter

> **DataPorter** is an open-source, JSON-configuration–driven tool for validating, transforming, and migrating bulk **Excel data** — designed as a developer-friendly and feature-rich alternative to [YoBulk.dev](https://www.yobulk.dev).

---

## ✨ Why DataPorter?

Most data migration/validation tools are either **UI-only**, **closed-source**, or **limited in scope**.  
**DataPorter** is different:

- ⚡ **Automation-first** → JSON Configuration 
- 📊 **Excel-native** → Validate & transform Excel out-of-the-box  
- 🔄 **Validation + Transformation + Migration** → all in one pipeline  
- 🔓 **Truly open-source** (GPL-3.0)  

---

## 🆚 YoBulk vs DataPorter

| Feature                | YoBulk.dev                          | **DataPorter** |
|------------------------|--------------------------------------|----------------|
| **Open-source**        | Partially                           | ✅ 100% GPL-3.0 |
| **Config style**       | UI-only                             | ✅ JSON configs |
| **Excel validation**   | ✅ Basic                            | ✅ Advanced (schema, regex, rules) |
| **Data transformation**| ❌ Not supported                     | ✅ Built-in (through json configured rules) |
| **Bulk migration**     | ❌ Limited                          | ✅ Scalable |
| **Extensibility**      | ❌ Closed                           | ✅ Pluggable |

---

## 🚀 Features

- **Excel File Validator** → enforce schema, regex, ranges, uniqueness  
- **Transformer Engine** → map, clean, and normalize bulk data  
- **JSON-driven Configs** → no vendor lock-in, reusable rules  
- **CLI & Library Support** → run standalone or embed in apps  
- **Extensible I/O** → start with Excel, extend to CSV, JSON, DBs  
- **Enterprise-scale Ready** → repeatable, automation-friendly pipelines  

---

## 🛠 Development Status

DataPorter is in **active development**. Below is the breakdown of completed, in-progress, and planned components.  
This status section is intended both for **users** (to know what works today) and **contributors** (to see where help is needed).

---

### 1️⃣ Core Processing Engine

- [x] **Excel Processor**
  - Implemented using [Apache POI](https://www.yobulk.dev](https://poi.apache.org/)) and [Streaming Reader](https://github.com/pjfanning/excel-streaming-reader) for handling large Excel files efficiently.
  - Supports streaming read instead of loading entire workbook into memory.
- [x] **Sheet Processor**
  - Iterates through sheets with streaming support.
  - Provides hooks for sheet-level validation and transformation.
- [x] **Row Processor**
  - Iterates through rows sequentially.
  - Provides hooks for row-level validation and transformation.

---

### 2️⃣ Validation Framework

**Validation is structured at three levels:**
- **Workbook-level**
- **Sheet-level**
- **Row-level**

#### Workbook-level Validation
- [ ] Rules not implemented yet  
  _(planned: sheet count limits, sheet naming conventions, metadata checks)_

#### Sheet-level Validation
- [x] Implemented Rules:
  - `emptyRowsValidation` → detects completely empty rows
  - `minRows` → ensures minimum row count
  - `maxRows` → ensures maximum row count

#### Row-level Validation
- [ ] Planned:
  - Data type validation (string, number, date, boolean, etc.)
  - Regex validation (e.g., email, phone number patterns)
  - Range validation (e.g., numeric min/max)
  - Uniqueness checks (across rows)
  - Nullability rules

---

### 3️⃣ Transformation Engine

- [ ] **Column Mapping**
  - Map input column → output column
- [ ] **Data Normalization**
  - Trim, lowercase/uppercase, date format conversion
- [ ] **Computed Fields**
  - Generate new fields based on formulas or transformations
- [ ] **Chained Transformations**
  - Apply multiple transformations in sequence

---

### 4️⃣ Configuration (JSON-driven)

- [x] Basic JSON parsing (read config file)
- [x] Validation rules defined in JSON
- [ ] Transformation rules defined in JSON
- [ ] Schema validation for configuration files

---

### 6️⃣ Input / Output Formats

- [x] Input: Excel (XLSX, streaming)
- [ ] Input: CSV
- [ ] Input: JSON
- [ ] Input: Database connectors
- [ ] Output: Excel
- [ ] Output: CSV
- [ ] Output: JSON
- [ ] Output: Database connectors

---

### 7️⃣ Testing & Quality

- [x] Unit tests implemented for:
  - Loading and Parsing Configuration
  - Sheet-level validation rules (`emptyRowsValidation`, `minRows`, `maxRows`)
  - Processor flow
  - Validation flow
- [ ] Integration tests for multi-level validation
- [ ] Benchmark tests for large Excel files
- [ ] Code coverage reporting (CI/CD integration)

---

### 8️⃣ Documentation

- [x] Developer Guide
- [ ] End-user Guide
- [x] Config reference (all validation & transformation rules)
- [ ] Example configs for real-world datasets

---




