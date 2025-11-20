# 📝 Helm Cheat Sheet

A quick reference for commonly used Helm commands.

---

## 1️⃣ Helm Repositories

| Command | Description |
|---------|-------------|
| `helm repo add <name> <url>` | Add a Helm repository |
| `helm repo update` | Update repository index |
| `helm search repo <chart-name>` | Search charts in repositories |

---

## 2️⃣ Helm Install / Upgrade / Uninstall

| Command | Description |
|---------|-------------|
| `helm install <release-name> <chart-path> --values values.yaml` | Install a chart into the cluster |
| `helm upgrade <release-name> <chart-path> --values values.yaml` | Upgrade an existing release |
| `helm upgrade --install <release-name> <chart-path> --values values.yaml` | Install if not exists, otherwise upgrade |
| `helm uninstall <release-name>` | Delete a release from the cluster |

---

## 3️⃣ Helm Status

| Command | Description |
|---------|-------------|
| `helm status <release-name>` | Show detailed status of a release, including deployed resources |

---

## 4️⃣ Helm List

| Command | Description |
|---------|-------------|
| `helm list` | List all releases in the current namespace |
| `helm list --all-namespaces` | List all releases across all namespaces |

---

## 5️⃣ Helm History & Rollback

| Command | Description |
|---------|-------------|
| `helm history <release-name>` | Show revision history of a release |
| `helm rollback <release-name> <revision>` | Rollback a release to a previous revision |

---

## 6️⃣ Debugging & Validation

| Command | Description |
|---------|-------------|
| `helm template <chart-path>` | Render templates locally without deploying |
| `helm lint <chart-path>` | Validate chart templates and values for errors |

---

## 7️⃣ Daily Workflow (Example)

```bash
# Build Docker image for Spring Boot app
docker build -t springboot-app:1.0.0 .

# Load image into Minikube
minikube image load springboot-app:1.0.0

# Install or upgrade Helm release
helm upgrade --install springboot-local ./demokchart --values values.yaml

# Check pod status
kubectl get pods

# Check release status
helm status springboot-local

# Access Helm history
helm history springboot-local

# Uninstall release if needed
helm uninstall springboot-local

# To get the external URL to access a Kubernetes service running in Minikube.
minikube service springboot-local-demokchart --url
