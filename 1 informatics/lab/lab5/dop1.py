import polars as p
file = (p.scan_csv("lab5 — копия.csv",separator = ';', has_header=False)
        .slice(offset = 3, length = 12)
        .collect()
        )

df_new = (p.scan_csv("lab5.csv", separator = ';', has_header=False)
        .slice(offset = 1, length = 12)
        .collect()
        )

file = file.rename({f"column_{i+1}": f"{i+1}" for i, name in enumerate(df_new.columns)})
df_new = df_new.rename({f"column_{i+1}": f"{i+1}" for i, name in enumerate(df_new.columns)})
out = df_new.select(p.concat_str(p.col(f"{i}" for i in range(1,20)))).rename({'1':'5'})
med_res= file.select('1','2','3','4')
result = p.concat([med_res,out],how = 'horizontal')
print(result)
