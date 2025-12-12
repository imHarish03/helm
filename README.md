# 🚀 Spring Boot Deployment on Minikube using Docker & Helm

This guide explains the complete workflow to deploy a Spring Boot application on **Minikube**, using **Docker**, **Helm**, and **Kubernetes ConfigMaps**.  
It also includes debugging steps and commonly-used commands.

---

# 🟦 1. Start Minikube

```bash
minikube start
```

---

# 🟦 2. Configure Docker to Use Minikube’s Docker Daemon

```bash
minikube -p minikube docker-env --shell powershell | Invoke-Expression
```

This ensures Docker builds images inside Minikube, so no registry push is required.

---

# 🟦 3. Build the Spring Boot Docker Image

```bash
docker build -t springboot-app:latest .
```

---

# 🟦 4. Check Existing Helm Releases (Optional)

```bash
helm list
```

---

# 🟦 5. Install or Upgrade the Helm Chart

```bash
helm upgrade demo-release .\demo-helm-repo -f .\demo-helm-repo\values-dev.yaml --install
```

Use `--install` to install if it does not already exist.

---

# 🟦 6. Preview Rendered Kubernetes Manifests

```bash
helm template demo-release .\demo-helm-repo -f .\demo-helm-repo\values-dev.yaml
```

Useful for debugging ConfigMaps, indentation, and final YAML output.

---

# 🟦 7. Check Kubernetes Services

```bash
kubectl get svc
```

---

# 🟦 8. Get Minikube Node IP

```bash
minikube ip
```

---

# 🟦 9. Open the Application URL via Minikube

```bash
minikube service demo-release-demokchart --url
```

---

# 🟦 10. Check Running Pods

```bash
kubectl get pods
```

---

# 🟦 11. View Pod Logs

```bash
kubectl logs <pod-name>
```

Example:

```bash
kubectl logs demo-release-demokchart-5656644b9c-x7sc7
```

---

# 🟦 12. Describe a Pod (Best for Debugging)

```bash
kubectl describe pod <pod-name>
```

Example:

```bash
kubectl describe pod demo-release-demokchart-5656644b9c-x7sc7
```

Shows events like image pull failure, mount errors, etc.

---

# 🟦 13. Exec into a Running Pod

```bash
kubectl exec -it <pod-name> -- sh
```

Example:

```bash
kubectl exec -it demo-release-demokchart-64465d9547-xnv9 -- sh
```

---

# 🟦 14. Inspect ConfigMap

```bash
kubectl describe configmap app-config
kubectl get configmap app-config -o yaml
```

---

# 🟦 15. Helm Release History

```bash
helm history demo-release
```

---

# 🟦 16. Roll Back a Failed Release

```bash
helm rollback demo-release <revision>
```

---

# 🟦 17. Uninstall Helm Release

```bash
helm uninstall demo-release
```

---

# 🟦 18. Delete All Kubernetes Resources (Optional Reset)

```bash
kubectl delete all --all
```

---

# 🟦 19. Stop Minikube

```bash
minikube stop
```

---

## ✔️ Summary

This guide provides:

- Complete Minikube start → Docker build → Helm deploy workflow  
- Debug steps (logs, describe, exec)  
- Helm history, rollback, template rendering  
- ConfigMap inspection  
- Commands to open service URL via Minikube  

---

## 📌 Feel free to enhance this README with:
- Architecture diagrams  
- Helm chart structure  
- CI/CD pipeline steps  
