data=read.csv(file.choose())
library(ggplot2)
lt<-c("solid", "blank", "dashed", "dotted", "dotdash", "longdash", "twodash", "1F", "F1", "4C88C488", "12345678")

# Greedy 
ggplot(data=data,aes(X, Y, group=Type, colour=Type,linetype=Type)) + 
  geom_line(size=1)+scale_size_area() + 
  labs(size= "Shortest Paths",
       x = "Select Target Pair",
       y = "Difference between perturbed Shortest path from Original Ones",
       title = "Greedy Perturbation 100% Targeted Pairs Being Preserved")+    
  # scale_colour_grey() +
  theme(panel.background = element_rect(fill='white', colour='black'))+
  geom_point(data=data, aes(x=X, y=Y))
 +scale_linetype_manual(values=lt)

#Gaussian
ggplot(subset(data,Type %in% c("Length" , "Weight"))) + 
  geom_line(aes(X, Y, group=Type, colour=Type,linetype=Type),size=1)+scale_size_area() + 
  labs(size= "Metrics",
       x = "Difference.from.the.Original.Ones",
       y = "Percentage",
       title = "Gaussian Randomization "~sigma*" = 0.15")+
 # scale_colour_grey() +
  theme(panel.background = element_rect(fill='white', colour='black'))+
  geom_point(data=data, aes(x=X, y=Y))+
  scale_linetype_manual(values=c("longdash", "solid"))


ggplot(subset(data,Type %in% c("G_Length" , "G_Weight"))) + 
  geom_line(aes(X, Y, group=Type, colour=Type,linetype=Type),size=1)+scale_size_area() + 
  labs(size= "Metrics",
       x = "Difference.from.the.Original.Ones",
       y = "Percentage",
       title = "Greedy Perturbation 75% Targeted Pairs Being Preserved")+    
  # scale_colour_grey() +
  theme(panel.background = element_rect(fill='white', colour='black'))+
  geom_point(data=data, aes(x=X, y=Y))+
  scale_linetype_manual(values=c("longdash", "solid"))

ggplot(subset(data,Type %in% c("E_Length" , "E_Weight"))) + 
  geom_line(aes(X, Y, group=Type, colour=Type,linetype=Type),size=1)+scale_size_area() + 
  labs(size= "Metrics",
       x = "Difference.from.the.Original.Ones",
       y = "Percentage",
       title = "K-Nearest, 75% Targeted Pairs Being Preserved")+    
  # scale_colour_grey() +
  theme(panel.background = element_rect(fill='white', colour='black'))+
  geom_point(data=data, aes(x=X, y=Y))+
  scale_linetype_manual(values=c("longdash", "solid"))

ggplot(subset(data,Type %in% c("G_Length" , "G_Weight"))) + 
  geom_line(aes(X, Y, group=Type, colour=Type)) +labs(size= "Metrics",
                                                      x = "Difference.from.the.Original.Ones",
                                                      y = "Percentage",
                                                      title = "Near By Shortest Paths Perturbation")

ggplot(subset(data,Type %in% c("E_Length" , "E_Weight"))) + 
  geom_line(aes(X, Y, group=Type, colour=Type)) +labs(size= "Metrics",
                                                      x = "Difference.from.the.Original.Ones",
                                                      y = "Percentage",
                                                      title = "Near By Shortest Paths Perturbation")

ggplot(subset(data,Type %in% c("G_Length" , "G_Weight"))) + 
  geom_line(aes(X, Y, group=Type, colour=Type)) +labs(size= "Metrics",
                                                      x = "Difference.from.the.Original.Ones",
                                                      y = "Percentage",
                                                      title = "NonVisited Edges Interchaning with Partial Edges")

ggplot(subset(data,Type %in% c("E_Length" , "E_Weight"))) + 
  geom_line(aes(X, Y, group=Type, colour=Type)) +labs(size= "Metrics",
                                                      x = "Difference.from.the.Original.Ones",
                                                      y = "Percentage",
                                                      title = "NonVisited Edges Interchaning with Partial Edges")
ggplot(data=data, aes(x=X, y=Y, group=Type,colour=Type)) +
  geom_line() +
  geom_point()+ scale_linetype_manual(values=c("solid", "blank", "dashed", "dotted", "dotdash", "longdash", "twodash", "1F", "F1", "4C88C488", "12345678"))



ggplot(subset(data,Type %in% c("Original" , "Enhance{0}", "Enhance{1}", "Greedy{1}", "Greedy{2}"))) + 
  geom_line(data=data,aes(X, Y, group=Type, colour=Type,linetype=Type),size=1)+scale_size_area() + 
  labs(size= "Shortest Paths",
       x = "Select Target Pair",
       y = "Difference between perturbed Shortest path from Original Ones",
       title = "Enhanced Greedy Perturbation")+    
  # scale_colour_grey() +
  theme(panel.background = element_rect(fill='white', colour='black'))+
  geom_point(data=data, aes(x=X, y=Y))
scale_linetype_manual(values=lt)
