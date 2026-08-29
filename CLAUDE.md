# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

CatTvLauncher：Android TV 桌面应用（Home 替换），Kotlin + View 体系 + ViewBinding（未使用 Compose，尽管版本目录中声明了 Compose 插件）。

## 关键约束

- **【强制】编码前必须读取 `doc/全局约束.md`，编码过程中将其作为第一要求遵守。**
- `MainActivity` 是 HOME 应用入口：`HOME` / `DEFAULT` / `LEANBACK_LAUNCHER` intent-filter、`singleTask` + `clearTaskOnLaunch`、拦截返回键（`onBackPressed` 为空）——这些 TV 桌面标准配置不可随意修改。
- 模块依赖方向：`:app` → `:appInfo` → `:commom`，不得反向依赖或在 `:commom` 中引入业务逻辑。
- `settings.gradle.kts` 中模块名为 `:appinfo`，磁盘目录为 `appInfo`（大小写不一致：Windows/macOS 可正常构建，Linux 大小写敏感环境会失败）。
- Gradle 仓库优先走阿里云镜像、wrapper 从腾讯镜像下载（国内网络环境构建），不要删除镜像配置。
- 依赖版本统一在 `gradle/libs.versions.toml` 中管理。
- 代码注释与 KDoc 使用中文。
- 新增模块时，必须在 `doc/模块/` 下新建对应模块目录，并补充《需求文档》与《技术文档》。

## 文档目录（doc/）

`doc/` 下为详细材料，按模块细分；**`doc/模块/` 下每个模块目录必须包含《需求文档》和《技术文档》**。

**请按需读取对应细分目录文档，不要一次性全部读取。**

| 路径 | 说明 |
|---|---|
| `doc/README.md` | 文档目录总览与索引 |
| `doc/全局约束.md` | **【强制读取】编码约束，编码过程第一要求** |
| `doc/全局架构.md` | 模块结构、依赖方向、入口与核心数据流 |
| `doc/模块/应用列表/` | 桌面核心功能：加载已安装应用、置顶排序、点击启动 |
| `doc/模块/壁纸/` | 桌面背景层（当前为占位实现） |
| `doc/模块/公共基础/` | commom 模块基础能力：全局 Context、日志、基类 |
